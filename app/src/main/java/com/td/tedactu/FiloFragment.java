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

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.td.tedactu.Adapter.PostAdapter;
import com.td.tedactu.models.ModelPost;

import java.util.ArrayList;
import java.util.Map;

public class FiloFragment extends Fragment {


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
    ImageView ivfantom9;
    ImageView ivfantom10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_filo, parent, false);

        ivfantom1 = view.findViewById(R.id.ivfilo1);
        ivfantom2 = view.findViewById(R.id.ivfilo2);
        ivfantom3 = view.findViewById(R.id.ivfilo3);
        ivfantom4 = view.findViewById(R.id.ivfilo4);
        ivfantom5 = view.findViewById(R.id.ivfilo5);
        ivfantom6 = view.findViewById(R.id.ivfilo6);
        ivfantom7 = view.findViewById(R.id.ivfilo7);
        ivfantom8 = view.findViewById(R.id.ivfilo8);
        ivfantom9 = view.findViewById(R.id.ivfilo9);
        ivfantom10 = view.findViewById(R.id.ivfilo10);

        toolbar = view.findViewById(R.id.toolbarfrag);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().onBackPressed();
                Backpresses();
            }
        });

        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118178589_2774080389492406_8274543481735660371_o_2774080386159073.jpg").into(ivfantom1);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118031775_2774077709492674_5631020775736867450_o_2774077706159341.jpg").into(ivfantom2);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117926777_2774078102825968_2059652091691855957_o_2774078099492635.jpg").into(ivfantom3);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117949565_2774080816159030_8618067947330301657_o_2774080812825697.jpg").into(ivfantom4);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117592128_2774078026159309_2030363733342461299_o_2774078022825976.jpg").into(ivfantom5);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117534857_2774080672825711_3546896907418758158_o_2774080669492378.jpg").into(ivfantom6);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118156031_2774078442825934_4787264407884542155_o_2774078439492601.jpg").into(ivfantom7);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117444330_2774077802825998_8561359064887203298_o_2774077799492665.jpg").into(ivfantom8);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117444687_2774078719492573_5445453191682828733_o_2774078716159240.jpg").into(ivfantom9);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/117633147_2774079826159129_7423766646175645724_o_2774079822825796.jpg").into(ivfantom10);

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
