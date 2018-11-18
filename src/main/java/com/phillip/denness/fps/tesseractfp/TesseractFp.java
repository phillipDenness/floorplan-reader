package com.phillip.denness.fps.tesseractfp;

import org.apache.commons.io.IOUtils;
import org.bytedeco.javacpp.BytePointer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.TessBaseAPI;

@Service
public class TesseractFp {
    private TessBaseAPI api;

    public TesseractFp() {
        api = new TessBaseAPI();
        if (api.Init("./tessdata", "eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }
    }

    public String[] getImgText(InputStream inputStream) {

        BytePointer outText;

        try {
            byte[] bytes = new byte[0];

            bytes = IOUtils.toByteArray(inputStream);
            PIX pix = pixReadMem(bytes, bytes.length);
            if (pix == null) {
                throw new IOException("Could not decode image from input stream");
            }
            api.SetImage(pix);
            outText = api.GetUTF8Text();
            String string = outText.getString();
            System.out.println("OCR output:\n" + string);

            // Destroy used object and release memory
            api.End();
            outText.deallocate();
            pixDestroy(pix);

            return string.split("\\r?\\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
