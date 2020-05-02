package com.td.tedactu.Api;

import com.td.tedactu.WPPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PolitiqueRetrofitArrayApi
{
    @GET("wp-json/wp/v2/posts?page=1&categories=16&_embed")
    Call<List<WPPost>> getPostInfo();
}
