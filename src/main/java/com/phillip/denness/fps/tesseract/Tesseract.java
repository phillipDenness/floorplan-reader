package com.phillip.denness.fps.tesseract;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class Tesseract {
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
