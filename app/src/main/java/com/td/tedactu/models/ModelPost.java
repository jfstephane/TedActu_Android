package com.td.tedactu.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelPost {
    public static final int IMAGE_TYPE = 1;
    public String title, subtitle, image, link;
    public int type;

    public String iframe;


    public ModelPost(int type, String link, String title, String subtitle, String image) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.type = type;
        this.link = link;




    /*

        public Article (JSONObject jsonObject) throws JSONException {




        String post = jsonObject.getString("content");
        if(post.contains("soundcloud") || post.contains("youtube")){
            Pattern REGEX_PATTERN = Pattern.compile("(?<=src=\")[^\"]*(?<!\")");
            Matcher matcher = REGEX_PATTERN.matcher(post);
            while (matcher.find()) {
                System.out.println(matcher.group());
                this.iframe = matcher.group(0);// match;
            }
        }else{
            this.iframe = null;
        }

    }




    public void setIframe(String iframe) {
        this.iframe = iframe;
    }


     */



    }

}


