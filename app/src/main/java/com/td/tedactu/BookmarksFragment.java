package com.td.tedactu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

class BookmarksFragment extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    Button btnNext;
    String firstPlaylist = "PLjEcaZaKnnSF9aCD_LcYOlDG_AqO3QYLq", secondPlaylist = "PLjEcaZaKnnSFvWoyXORcqJnEqEd4v7exb", thirdPlaylist = "PLjEcaZaKnnSFBSSZMArgCi-buobrBpV8g";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_bookmarks);


    }
}
