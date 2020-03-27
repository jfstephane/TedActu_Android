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

        youTubePlayerView = findViewById(R.id.youtubePlayer);
        btnNext = findViewById(R.id.btnNext);

        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b)
            {
                youTubePlayer.loadPlaylist(firstPlaylist);

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        youTubePlayer.loadPlaylist(secondPlaylist);
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
