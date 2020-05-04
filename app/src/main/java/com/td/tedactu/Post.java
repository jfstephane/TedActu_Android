package com.td.tedactu;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.util.Log;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Post extends AppCompatActivity {
    TextView title;
    ImageView image;
    TextView content;


    Toolbar toolbar;

    Button share, download;


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
        download = findViewById(R.id.download);

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
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, linkString);
                startActivity(Intent.createChooser(shareIntent, "Share using: "));
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebURL(imageString);
            }
        });

    }

    public void openWebURL( String inURL ) {
        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

        startActivity( browse );
    }

}