package com.example.waiterstation;

public class StaticRecyclerModel {

    private int image;
    private String text;

    public StaticRecyclerModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
