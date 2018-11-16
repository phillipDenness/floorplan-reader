package com.phillip.denness.fps.domain;

import java.io.Serializable;
import java.util.List;

public class Floorplan implements Serializable {

    private String url;

    private String[] extactedText;
    private String totalSquareArea;

    public String[] getExtactedText() {
        return extactedText;
    }

    public void setExtactedText(String[] extactedText) {
        this.extactedText = extactedText;
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
