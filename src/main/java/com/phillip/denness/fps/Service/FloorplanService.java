package com.phillip.denness.fps.Service;

import com.phillip.denness.fps.domain.Floorplan;
import com.phillip.denness.fps.tesseractfp.TesseractFp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FloorplanService {

    @Autowired
    private ImageFetch imageFetch;

    @Autowired
    private TesseractFp tesseractFp;

    public void processImage(Floorplan floorplan) {
        try {
            InputStream is = imageFetch.download(floorplan);
            String[] extractedText = tesseractFp.getImgText(is);

            String totalSquareArea = getTotalSquareArea(extractedText);

            floorplan.setTotalSquareArea(totalSquareArea);
            floorplan.setExtractedText(extractedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTotalSquareArea(String[] extractedText) {
        try {
            for (String line : extractedText) {
                line = line.toLowerCase();
                System.out.println(line);
                if (line.contains("total") && line.contains("area")) {
                    return line;
                }
                if (line.contains("floor") && line.contains("area")) {
                    return line;
                }
//            }else if (line.contains("total") && line.contains("area")) {
//                return line;
//            } else if (line.contains("total")) {
//                return line;
//            } else if (line.contains("area")) {
//                return line;
//            } else if (line.contains("floor")) {
//                return line;
//            } else if (line.contains("sq")) {
//                return line;
//            }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
