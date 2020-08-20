package com.td.tedactu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sliderviewlibrary.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class ListCategories extends Fragment {


    ImageView imgPolitique;
    ImageView imgSociete;
    ImageView imgCulture;
    ImageView imgSport;
    ImageView imgSavoirPLus;
    ImageView imgAnket;
    ImageView imgGallery;



    ViewPager viewPager;
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<String> Urls = new ArrayList<>();
    SliderView sliderView;
    int DELAY_MS=1000,PERIOD_MS=5000;
    int currentPage=0;


    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view =inflater.inflate(R.layout.listcategories, parent, false);


/*
        EasySlider easySlider = view.findViewById(R.id.slider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("title1",R.drawable.anket));
        sliderItems.add(new SliderItem("title2",R.drawable.culture));
        sliderItems.add(new SliderItem("title3",R.drawable.sport));
        sliderItems.add(new SliderItem("title4",R.drawable.societe));
        easySlider.setPages(sliderItems);






        sliderView=view.findViewById(R.id.sliderView);
        //SliderAdapter sliderAdapter = new SliderAdapter(getApplicationContext(),viewPager);
        images.add(R.drawable.anket);
        images.add(R.drawable.culture);
        images.add(R.drawable.nlw2x);


        Urls.add("https://cdn140.picsart.com/257737415006202.jpg?c256x256");
        Urls.add("https://stephanianforum.files.wordpress.com/2015/07/holi-celbration.jpg?w=256&h=256&crop=1");
        Urls.add("https://static-s.aa-cdn.net/img/ios/1175689019/5f18f297b9258db5c13af41d70309379?v=1");
        sliderView.setImages(images);
        //OR
        //sliderView.setImages(IMAGES);
        TimerTask task = sliderView.getTimerTask();
        Timer timer = new Timer();
        //tabLayout.setupWithViewPager(viewPager, true);
        timer.schedule(task,DELAY_MS,PERIOD_MS);
 */



        imgPolitique =view.findViewById(R.id.imgpolitique);
        imgPolitique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new PolitiqueFragment());
                ft.commit();
            }
        });

        imgSociete =view.findViewById(R.id.imgsociete);
        imgSociete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new SocieteFragment());
                ft.commit();
            }
        });


        imgCulture =view.findViewById(R.id.imgculture);
        imgCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new CultureFragment());
                ft.commit();
            }
        });


        imgSport =view.findViewById(R.id.imgsport);
        imgSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new SportFragment());
                ft.commit();
            }
        });

        imgSavoirPLus =view.findViewById(R.id.imgsavoirplus);
        imgSavoirPLus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new SavoirPlusFragment());
                ft.commit();
            }
        });


        imgAnket =view.findViewById(R.id.imganket);
        imgAnket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Do something
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new AnketFragment());
                ft.commit();
            }
        });


        return view;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }


}
