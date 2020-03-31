package com.td.tedactu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ViewHolder>
{
    ArrayList<String> videoIds;
    Context mContext;

    public YoutubeAdapter(ArrayList<String> videoIds, Context mContext) {
        this.videoIds = videoIds;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.youtube_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final String id = videoIds.get(i);

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Loading Videos");
        progressDialog.setMessage("Please wait a few seconds...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        viewHolder.youTubePlayerView.initialize(YoutubeConfig.getApiKey(), new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {



                youTubeThumbnailLoader.setVideo(id);
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                    }
                });
                progressDialog.dismiss();
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                progressDialog.dismiss();
            }

        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent playerIntent = new Intent(mContext, PlayerActivity.class);
                playerIntent.putExtra("videoID", id);
                mContext.startActivity(playerIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoIds.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder
   {
       YouTubeThumbnailView youTubePlayerView;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           youTubePlayerView = itemView.findViewById(R.id.youtubePlayerView);
       }
   }
}
