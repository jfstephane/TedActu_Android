package com.td.tedactu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.td.tedactu.Post;
import com.td.tedactu.R;
import com.td.tedactu.models.ModelPost;

import java.util.List;
import java.util.Map;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>
{
    private Context context;
    private List<ModelPost> postList;

    Gson gson, picGson;
    Map<String, Object> mapMedia;
    Map<String, Object> mapDetails;
    Map<String, Object> mapSizes;
    Map<String, Object> mapRealSize;

    public PostAdapter(Context context, List<ModelPost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_article, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final ModelPost object = postList.get(i);

        viewHolder.titleText.setText(object.title);
        Picasso.get().load(object.image).placeholder(R.drawable.ic_drawable_camera_fill).into(viewHolder.imageText);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, Post.class);
                intent.putExtra("title", object.title);
                intent.putExtra("image", object.image);
                intent.putExtra("content", object.subtitle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout container;
        TextView titleText;
        ImageView imageText;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            titleText = itemView.findViewById(R.id.titleArticle);
            imageText = itemView.findViewById(R.id.ivArticle);
            container = itemView.findViewById(R.id.container);
        }
    }
}
