package com.phillip.denness.fps.domain;

import java.io.Serializable;

public class Floorplan implements Serializable {

    private String url;

    private String[] extractedText;
    private String totalSquareArea;

    public String[] getExtractedText() {
        return extractedText;
    }

    public void setExtractedText(String[] extractedText) {
        this.extractedText = extractedText;
    }

    public String getTotalSquareArea() {
        return totalSquareArea;
    }

    public void setTotalSquareArea(String totalSquareArea) {
        this.totalSquareArea = totalSquareArea;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
