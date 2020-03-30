package com.td.tedactu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

public class BookmarksActivity extends YouTubeBaseActivity
{
    RecyclerView recyclerView;
    YoutubeAdapter youtubeAdapter;
    ArrayList<String> videoIds;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_bookmarks);

        recyclerView = findViewById(R.id.recyclerBookmarks);

        videoIds = new ArrayList<>();
        videoIds.add("UftZhK_9IF0");
        videoIds.add("tarRAraOE_o");
        videoIds.add("zzdCFYGLWjk");
        videoIds.add("B2QITLt-lyQ");

        youtubeAdapter = new YoutubeAdapter(videoIds, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(youtubeAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
