package com.phillip.denness.fps.Service;

import com.phillip.denness.fps.domain.Floorplan;
import com.phillip.denness.fps.tesseract.TesseractFps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FloorplanService {

    @Autowired
    private ImageFetch imageFetch;

    @Autowired
    private TesseractFps tesseractFps;

    public void processImage(Floorplan floorplan) {
        try {
            String[] extractedText = tesseractFps.getImgText(imageFetch.download(floorplan));
            floorplan.setTotalSquareArea(getTotalSquareArea(extractedText));
            floorplan.setExtactedText(extractedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTotalSquareArea(String[] extractedText) {
        List<String> totalSquareAreas = new ArrayList<>();
        for (String line : extractedText) {
            if (line.toLowerCase().contains("sq")) {
                totalSquareAreas.add(line);
            }
        }

        return totalSquareAreas.get(0);
    }
}
