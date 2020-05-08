package com.td.tedactu;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.td.tedactu.Adapter.PostAdapter;
import com.td.tedactu.Api.PolitiqueRetrofitArrayApi;
import com.td.tedactu.Api.SavoirPlusRetrofitArrayApi;
import com.td.tedactu.models.ModelPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SavoirPlusFragment extends Fragment {

    Toolbar toolbar;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<ModelPost> postArrayList;
    private PostAdapter postAdapter;
    Gson gson, picGson;
    Map<String, Object> mapMedia;
    Map<String, Object> mapDetails;
    Map<String, Object> mapSizes;
    Map<String, Object> mapRealSize;

    public String baseURL = "https://tedactu.com";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_savoirplus, parent, false);


        recyclerView = view.findViewById(R.id.rvsavoirplus);
        progressBar = view.findViewById(R.id.pbsavoirplus);




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

        postAdapter = new PostAdapter(getContext(), postArrayList);

        recyclerView.setAdapter(postAdapter);



        toolbar = view.findViewById(R.id.toolbarfrag);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().onBackPressed();
                Backpresses();
            }
        });

        return view;

    }


    private void Backpresses() {
        //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contant_main, new Home()).commit();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, new ListCategories());
        ft.commit();
    }




    private void getRetrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SavoirPlusRetrofitArrayApi service = retrofit.create(SavoirPlusRetrofitArrayApi.class);
        Call<List<WPPost>> call = service.getPostInfo();

        call.enqueue(new Callback<List<WPPost>>() {
            @Override
            public void onResponse(Call<List<WPPost>> call, final Response<List<WPPost>> response) {

                progressBar.setVisibility(View.GONE);
                for (int i = 0; i < response.body().size(); i++) {
                    response.body().get(i).getId();

                    String tempdetails = response.body().get(i).getExcerpt().getRendered();
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
            }

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onStart()
    {
        super.onStart();

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }


}
