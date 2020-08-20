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

public class YanickFragment extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_yanick, parent, false);

        ivfantom1 = view.findViewById(R.id.ivyanick1);
        ivfantom2 = view.findViewById(R.id.ivyanick2);
        ivfantom3 = view.findViewById(R.id.ivyanick3);
        ivfantom4 = view.findViewById(R.id.ivyanick4);
        ivfantom5 = view.findViewById(R.id.ivyanick5);
        ivfantom6 = view.findViewById(R.id.ivyanick6);
        ivfantom7 = view.findViewById(R.id.ivyanick7);
        ivfantom8 = view.findViewById(R.id.ivyanick8);
        ivfantom9 = view.findViewById(R.id.ivyanick9);
        ivfantom10 = view.findViewById(R.id.ivyanick10);

        toolbar = view.findViewById(R.id.toolbarfrag);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().onBackPressed();
                Backpresses();
            }
        });

        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118157195_2774390766128035_2928077290572088454_o_2774390762794702.jpg").into(ivfantom1);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118144168_2774390579461387_1203696800965668480_o_2774390566128055.jpg").into(ivfantom2);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118137785_2774391872794591_6692783594803190466_o_2774391866127925.jpg").into(ivfantom3);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118060721_2774391642794614_4188152994730236455_o_2774391636127948.jpg").into(ivfantom4);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118208342_2774390196128092_6601772096317801837_o_2774390192794759.jpg").into(ivfantom5);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118105632_2774390529461392_3035020283839253522_o_2774390519461393.jpg").into(ivfantom6);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118125533_2774390339461411_2639433436966838424_o_2774390332794745.jpg").into(ivfantom7);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118250693_2774391956127916_6242794448626961115_o_2774391949461250.jpg").into(ivfantom8);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118225349_2774391282794650_3072432489705770349_o_2774391279461317.jpg").into(ivfantom9);
        Picasso.get().load("https://tedactu.com/wp-content/uploads/2020/08/118155337_2774390129461432_7799127218324845054_o_2774390122794766.jpg").into(ivfantom10);

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
