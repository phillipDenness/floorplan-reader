package com.phillip.denness.gumtree.tess;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.net.URL;

@Service
public class Tess {
    public String getImgText(URL imageLocation) {
        ITesseract instance = new Tesseract();
        try
        {
            ClassLoader classLoader = getClass().getClassLoader();
            String imgText = instance.doOCR(new File(classLoader.getResource("floorplan.jpg").getFile()));
            return imgText;
        }
        catch (TesseractException e)
        {
            e.getMessage();
            return "Error while reading image";
        }
    }
}
