package com.td.tedactu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Post extends AppCompatActivity {
    TextView title;
    ImageView image;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        final String titleString = getIntent().getExtras().getString("title");
        final String imageString = getIntent().getExtras().getString("image");
        final String contentString = getIntent().getExtras().getString("content");

        title = findViewById(R.id.title);
        image = findViewById(R.id.imageDetails);
        content = findViewById(R.id.content);

        title.setText(titleString);
        content.setText(contentString);

        Picasso.get().load(imageString).placeholder(R.drawable.ic_drawable_camera_fill).into(image);
    }


}