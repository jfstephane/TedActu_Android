package com.td.tedactu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GalleryFragment extends Fragment {


    ImageView iv1;
    ImageView iv2;
    ImageView iv3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragmet_gallery, parent, false);


        iv1 =view.findViewById(R.id.iv1);
        iv2 =view.findViewById(R.id.iv2);
        iv3 =view.findViewById(R.id.iv3);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new FantomFragment());
                ft.commit();

                //Intent intent = new Intent(getContext(), BookmarksActivity.class);
                //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                //startActivity(intent);
            }
        });



        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new FiloFragment());
                ft.commit();

                //Intent intent = new Intent(getContext(), BookmarksActivity.class);
                //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                //startActivity(intent);
            }
        });


        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new YanickFragment());
                ft.commit();

                //Intent intent = new Intent(getContext(), BookmarksActivity.class);
                //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                //startActivity(intent);
            }
        });



        return view;

    }





    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }



}
