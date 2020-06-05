package com.td.tedactu.Api;

import com.td.tedactu.WPPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface RetrofitArrayApi
{
    @GET
    Call<List<WPPost>> getPostInfo(@Url String url);
}
