package com.td.tedactu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class BookmarksActivity extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button btnNext, btnPrevious;
    String firstPlaylist = "PLjEcaZaKnnSF9aCD_LcYOlDG_AqO3QYLq", secondPlaylist = "PLjEcaZaKnnSFvWoyXORcqJnEqEd4v7exb", thirdPlaylist = "PLjEcaZaKnnSFBSSZMArgCi-buobrBpV8g";
    int i = 0;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_bookmarks);

        final ArrayList<String> playListArray = new ArrayList<>();
        playListArray.add(firstPlaylist);
        playListArray.add(secondPlaylist);
        playListArray.add(thirdPlaylist);

        youTubePlayerView = findViewById(R.id.youtubePlayer);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);

        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b)
            {
                youTubePlayer.loadPlaylist(playListArray.get(i));

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if (i != playListArray.size() - 1)
                        {
                            i++;
                            youTubePlayer.loadPlaylist(playListArray.get(i));
                        }
                        else
                        {
                            btnNext.setEnabled(false);
                        }
                    }
                });

                btnPrevious.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(i == 0)
                        {
                            btnPrevious.setEnabled(false);
                            btnNext.setEnabled(true);
                        }
                        else
                        {
                            i--;
                            youTubePlayer.loadPlaylist(playListArray.get(i));
                            btnNext.setEnabled(true);
                        }
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
