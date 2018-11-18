package com.phillip.denness.fps.tesseractfp;

import org.apache.commons.io.IOUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.tesseract;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.TessBaseAPI;

@Service
public class TesseractFp {
    private TessBaseAPI api;

    public String[] getImgText(InputStream inputStream) {
        try {
            api = new TessBaseAPI();
            if (api.Init("./tessdata", "eng") != 0) {
                System.err.println("Could not initialize tesseract.");
                System.exit(1);
            }

            BytePointer outText;
            try {
                byte[] bytes = new byte[0];
                bytes = IOUtils.toByteArray(inputStream);
                PIX pix = pixReadMem(bytes, bytes.length);
                if (pix == null) {
                    throw new IOException("Could not decode image from input stream");
                }
                api.SetImage(pix);

                tesseract.TessBaseAPISetImage2(api, pix);
                //To remove the warning message "Warning. Invalid resolution 1 dpi. Using 70 instead." Setting the resolution
                int  res = tesseract.TessBaseAPIGetSourceYResolution(api);
                if (res < 70)
                    tesseract.TessBaseAPISetSourceResolution(api, 70);

                outText = api.GetUTF8Text();
                String string = outText.getString();
                System.out.println(string);
                // Destroy used object and release memory
                api.End();
                outText.deallocate();
                pixDestroy(pix);

                return string.split("\\r?\\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
