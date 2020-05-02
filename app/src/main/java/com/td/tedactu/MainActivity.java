package com.td.tedactu;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //BottomNAvigation
    private String mPackageName;
    private List<BottomItem> mBnbDrawableModeList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPackageName = getApplicationInfo().packageName;

        initBnbDrawableMode();

    }


    private void initBnbDrawableMode() {
        mBnbDrawableModeList = new ArrayList<>();
        //mTvBnbDrawableMode = (TextView) findViewById(R.id.tv_bnb_drawable);
        BottomNavigationBar mBnbDrawable = (BottomNavigationBar) findViewById(R.id.bnb_drawable);
        mBnbDrawable.addOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
            @Override
            public void OnSelected(int oldPosition, int newPosition) {
                //mTvBnbDrawableMode.setText("Drawable Mode : " + mBnbDrawableModeList.get(newPosition).getText());

                //FragmentManager

                if (newPosition == 0)
                {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, new HomeFragment());
                        ft.commit();

                }
                else if (newPosition == 1){

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new ListCategories());
                   ft.commit();
                    Toast.makeText(MainActivity.this, "Position 2", Toast.LENGTH_SHORT).show();
                }
                else if (newPosition == 2){

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new SearchFragment());
                    ft.commit();
                    Toast.makeText(MainActivity.this, "Position 3", Toast.LENGTH_SHORT).show();
                }
                else if (newPosition == 3){

                    Intent intent = new Intent(MainActivity.this, BookmarksActivity.class);
                    startActivity(intent);
                }
                else if (newPosition == 4){

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new AboutFragment());
                    ft.commit();
                    Toast.makeText(MainActivity.this, "Position 5", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BottomItem item1 = new BottomItem();
        item1.setMode(BottomItem.DRAWABLE_MODE);
        item1.setText("Home");
        item1.setActiveIconResID(getResources().getIdentifier("feedsel", "drawable",
                getApplicationInfo().packageName));
        item1.setInactiveIconResID(getResources().getIdentifier("feed", "drawable",
                getApplicationInfo().packageName));
        item1.setActiveTextColor(Color.parseColor("#FC7823"));
        mBnbDrawable.addItem(item1);
        mBnbDrawableModeList.add(item1);

        BottomItem item2 = new BottomItem();
        item2.setMode(BottomItem.DRAWABLE_MODE);
        item2.setText("Categories");
        item2.setActiveIconResID(getResources().getIdentifier("categoriessel", "drawable",
                getApplicationInfo().packageName));
        item2.setInactiveIconResID(getResources().getIdentifier("categories", "drawable",
                getApplicationInfo().packageName));
        item2.setActiveTextColor(Color.parseColor("#FC7823"));
        mBnbDrawable.addItem(item2);
        mBnbDrawableModeList.add(item2);

        BottomItem item3 = new BottomItem();
        item3.setMode(BottomItem.DRAWABLE_MODE);
        item3.setText("Gallery");
        item3.setActiveIconResID(getResources().getIdentifier("gallerysel", "drawable",
                getApplicationInfo().packageName));
        item3.setInactiveIconResID(getResources().getIdentifier("gallery", "drawable",
                getApplicationInfo().packageName));
        item3.setActiveTextColor(Color.parseColor("#FC7823"));
        mBnbDrawable.addItem(item3);
        mBnbDrawableModeList.add(item3);

        BottomItem item4 = new BottomItem();
        item4.setMode(BottomItem.DRAWABLE_MODE);
        item4.setText("Videos");
        item4.setActiveIconResID(getResources().getIdentifier("videosel", "drawable",
                getApplicationInfo().packageName));
        item4.setInactiveIconResID(getResources().getIdentifier("video", "drawable",
                getApplicationInfo().packageName));
        item4.setActiveTextColor(Color.parseColor("#FC7823"));
        mBnbDrawable.addItem(item4);
        mBnbDrawableModeList.add(item4);

        BottomItem item5 = new BottomItem();
        item5.setMode(BottomItem.DRAWABLE_MODE);
        item5.setText("About");
        item5.setActiveIconResID(getResources().getIdentifier("aboutsel", "drawable",
                getApplicationInfo().packageName));
        item5.setInactiveIconResID(getResources().getIdentifier("about", "drawable",
                getApplicationInfo().packageName));
        item5.setActiveTextColor(Color.parseColor("#FC7823"));
        mBnbDrawable.addItem(item5);
        mBnbDrawableModeList.add(item5);

        mBnbDrawable.setSelectedPosition(0); //Set default selected item
        //mTvBnbDrawableMode.setText("Drawable Mode : " + mBnbDefaultList.get(2).getText());
        mBnbDrawable.initialize();

        //mBnbDrawable.setBadgeText(0, "WOW");
        //mBnbDrawable.setBadgeText(1, "");
        //mBnbDrawable.setBadgeText(2, "赞");
        //mBnbDrawable.setBadgeText(3, "");
        //mBnbDrawable.setBadgeText(4, "紧急");
    }

}
