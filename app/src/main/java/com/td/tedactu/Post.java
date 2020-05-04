package com.td.tedactu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Post extends AppCompatActivity {
    TextView title;
    ImageView image;
    TextView content;
    Button share;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        final String titleString = getIntent().getExtras().getString("title");
        final String imageString = getIntent().getExtras().getString("image");
        final String contentString = getIntent().getExtras().getString("content");
        final String linkString = getIntent().getExtras().getString("link");

        title = findViewById(R.id.title);
        image = findViewById(R.id.imageDetails);
        content = findViewById(R.id.content);
        share = findViewById(R.id.share);

        toolbar = findViewById(R.id.toolbarfrag);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });


        title.setText(titleString);
        content.setText(contentString);

        Picasso.get().load(imageString).placeholder(R.drawable.ic_drawable_camera_fill).into(image);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = linkString;
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });


    }


}