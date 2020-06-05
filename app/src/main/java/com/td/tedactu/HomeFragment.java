package com.td.tedactu;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.td.tedactu.Adapter.PostAdapter;
import com.td.tedactu.Api.RetrofitArrayApi;
import com.td.tedactu.models.ModelPost;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import am.appwise.components.ni.NoInternetDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    private ArrayList<ModelPost> postArrayList;
    private PostAdapter postAdapter;

    private NoInternetDialog noInternetDialog;
    String baseURL = "https://tedactu.com";
    private String yourURL;
    private int currentPage = 1;

    FloatingActionButton fabPrevious, fabNext;


    //public String baseURL = "http://ted.policite.org";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_home, parent, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progressBar);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);

        fabPrevious = view.findViewById(R.id.previous);
        fabNext = view.findViewById(R.id.next);

        noInternetDialog = new NoInternetDialog.Builder(getContext()).build();

        fabPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPage == 2){
                    fabPrevious.hide();
                }

                postArrayList.clear();
                currentPage --;
                getRetrofit(currentPage);
            }
        });

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postArrayList.clear();
                currentPage ++;
                getRetrofit(currentPage);
                fabPrevious.show();
            }
        });

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        //recyclerView.setLayoutManager(manager);

/*
        if(getOrientation() == HORIZONTAL){
            layoutParams.width = (int) Math.round(getHorizontalSpace() / (double) getItemCount());
        }
        else if(getOrientation() == VERTICAL){
            layoutParams.height = (int) Math.round(getVerticalSpace() /  (double) getItemCount());
        }


 */

        postArrayList = new ArrayList<>();

        if(!isNetworkConnected())
        {
            Toast.makeText(getContext(), "Check if network is connected", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }

        if(isInternetAvailable())
        {
            Toast.makeText(getContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }

        getRetrofit(currentPage);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                postArrayList.clear();
                getRetrofit(currentPage);
            }
        });

        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        postAdapter = new PostAdapter(getContext(), postArrayList);

        recyclerView.setAdapter(postAdapter);

        return view;
    }

    private void getRetrofit(int page)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);

//         String yourURL = baseURL.replace(baseURL,"https://tedactu.com/wp-json/wp/v2/posts?&_embed&page=1&per_page=5");


        Call<List<WPPost>>  call = service.getPostInfo("https://tedactu.com/wp-json/wp/v2/posts?&_embed&page="+ page + "&per_page=5");

        call.enqueue(new Callback<List<WPPost>>() {
            @Override
            public void onResponse(Call<List<WPPost>> call, final Response<List<WPPost>> response) {

                if(response.body() != null)
                {
                    progressBar.setVisibility(View.GONE);
                    for (int i = 0; i < response.body().size(); i++) {
                        response.body().get(i).getId();

                        String tempdetails = response.body().get(i).getContent().getRendered();
                        tempdetails = tempdetails.replace("<p>","");
                        tempdetails = tempdetails.replace("</p>","");
                        tempdetails = tempdetails.replace("[&hellip;]","");
                        tempdetails = tempdetails.replace("&#8217","");

                        postArrayList.add(new ModelPost(ModelPost.IMAGE_TYPE,
                                response.body().get(i).getLink(),
                                response.body().get(i).getTitle().getRendered(),
                                tempdetails,
                                response.body().get(i).getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getFull().getSourceUrl()));
                    }

                    postAdapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                }
                else
                {
                    Toast.makeText(getContext(), "Response body is null", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("https://www.google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        noInternetDialog.onDestroy();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        if(currentPage == 1){
            fabPrevious.hide();
        }
    }


}

