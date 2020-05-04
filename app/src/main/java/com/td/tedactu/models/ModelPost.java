package com.td.tedactu.models;

public class ModelPost
{
    public static final int IMAGE_TYPE = 1;
    public String title, subtitle, image, link;
    public int type;

    public ModelPost(int type, String link, String title, String subtitle, String image) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.type = type;
        this.link = link;
    }
}
