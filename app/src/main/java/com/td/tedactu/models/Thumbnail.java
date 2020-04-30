package com.td.tedactu.models;

import org.json.JSONObject;

public class Thumbnail
{
    String id, title;

    public Thumbnail(String id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
