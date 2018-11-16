package com.phillip.denness.fps.tesseract;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.*;

@Service
public class TesseractFps {

    public String[] getImgText(BufferedImage inputStream) {

        Tesseract instance = new net.sourceforge.tess4j.Tesseract();
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        op.filter(inputStream, inputStream); // gray scaling the image
        try {
            return instance.doOCR(inputStream).split("\\r?\\n");
        } catch (TesseractException e) {
            System.out.println("error:" + e);
            return null;
        }
    }

    public String getImgText(String imageName) {
        ITesseract instance = new net.sourceforge.tess4j.Tesseract();
        try
        {
            ClassLoader classLoader = getClass().getClassLoader();
            String imgText = instance.doOCR(new File(classLoader.getResource(imageName).getFile()));
            return imgText;
        }
        catch (TesseractException e)
        {
            e.getMessage();
            return "Error while reading image";
        }
    }
}
