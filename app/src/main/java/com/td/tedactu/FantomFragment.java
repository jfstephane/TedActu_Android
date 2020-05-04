package com.td.tedactu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.td.tedactu.Adapter.PostAdapter;
import com.td.tedactu.Api.PolitiqueRetrofitArrayApi;
import com.td.tedactu.models.ModelPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FantomFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    Toolbar toolbar;

    private ArrayList<ModelPost> postArrayList;
    private PostAdapter postAdapter;
    Gson gson, picGson;
    Map<String, Object> mapMedia;
    Map<String, Object> mapDetails;
    Map<String, Object> mapSizes;
    Map<String, Object> mapRealSize;

    public String baseURL = "https://tedactu.com";
    ImageView ivfantom1;
    ImageView ivfantom2;
    ImageView ivfantom3;
    ImageView ivfantom4;
    ImageView ivfantom5;
    ImageView ivfantom6;
    ImageView ivfantom7;
    ImageView ivfantom8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_fantom, parent, false);

        ivfantom1 = view.findViewById(R.id.ivfantom1);
        ivfantom2 = view.findViewById(R.id.ivfantom2);
        ivfantom3 = view.findViewById(R.id.ivfantom3);
        ivfantom4 = view.findViewById(R.id.ivfantom4);
        ivfantom5 = view.findViewById(R.id.ivfantom5);
        ivfantom6 = view.findViewById(R.id.ivfantom6);
        ivfantom7 = view.findViewById(R.id.ivfantom7);
        ivfantom8 = view.findViewById(R.id.ivfantom8);

        toolbar = view.findViewById(R.id.toolbarfrag);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().onBackPressed();
                Backpresses();
            }
        });

        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom8.jpg").into(ivfantom1);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom7.jpg").into(ivfantom2);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom6.jpg").into(ivfantom3);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom5.jpg").into(ivfantom4);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom4.jpg").into(ivfantom5);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom3.jpg").into(ivfantom6);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom2.jpg").into(ivfantom7);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/05/509fantom1.jpg").into(ivfantom8);

        return view;


    }

    private void Backpresses() {
        //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contant_main, new Home()).commit();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, new GalleryFragment());
        ft.commit();
    }





    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }


}
