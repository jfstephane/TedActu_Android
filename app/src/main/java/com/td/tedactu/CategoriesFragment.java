package com.td.tedactu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CategoriesFragment extends Fragment {

    ImageView imgPolitique;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_categories, parent, false);


        imgPolitique =view.findViewById(R.id.imgpolitique);
        imgPolitique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framecategories, new PolitiqueFragment());
                ft.commit();
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
/*
    public void onPolitique(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framecategories, new PolitiqueFragment());
        ft.commit();
    }*/

    private FragmentManager getSupportFragmentManager() {
        return null;
    }


}
