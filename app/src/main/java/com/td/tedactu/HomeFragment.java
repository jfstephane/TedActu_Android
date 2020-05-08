package com.td.tedactu;

import android.content.res.Configuration;
import android.os.Bundle;
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

    Gson gson, picGson;
    Map<String, Object> mapMedia;
    Map<String, Object> mapDetails;
    Map<String, Object> mapSizes;
    Map<String, Object> mapRealSize;

    public String baseURL = "https://tedactu.com";
    private NoInternetDialog noInternetDialog;

    //public String baseURL = "http://ted.policite.org";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_home, parent, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progressBar);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);

        noInternetDialog = new NoInternetDialog.Builder(getContext()).build();


        //linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //recyclerView.setLayoutManager(linearLayoutManager);


        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);

        }
        else{

            GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(),2);
            recyclerView.setLayoutManager(mLayoutManager);
        }






        postArrayList = new ArrayList<>();

        getRetrofit();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getRetrofit();
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

    private void getRetrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);
        Call<List<WPPost>> call = service.getPostInfo();

        call.enqueue(new Callback<List<WPPost>>() {
            @Override
            public void onResponse(Call<List<WPPost>> call, final Response<List<WPPost>> response) {

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

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
    }


}
