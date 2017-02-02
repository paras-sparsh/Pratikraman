package com.example.home.pratikraman_14.HomePage.DisplayPath;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.pratikraman_14.HomePage.HomePageActivity;
import com.example.home.pratikraman_14.HomePage.Parts;
import com.example.home.pratikraman_14.HomePage.Path;
import com.example.home.pratikraman_14.HomePage.SubPaths.ExpandedNavigationDrawer;
import com.example.home.pratikraman_14.R;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayPathActivity extends AppCompatActivity {
    TextView textViewDisplayPath;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_path);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //createList();

        Intent intent = getIntent();
     String pos = intent.getStringExtra("id");
        //mCustomPagerAdapter = new CustomPagerAdapter(this,completeList);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);
//        mViewPager.setAdapter(mCustomPagerAdapter);
//        mViewPager.setCurrentItem(getTheObject(pos));

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                setTitle(completeList.get(position).getTitle());
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });


        //textViewDisplayPath = (TextView)findViewById(R.id.textViewPath);
//        Typeface typeFace= Typeface.createFromAsset(getAssets(),"helveticaMedium.ttf");
//        textViewDisplayPath.setTypeface(typeFace);
//        Intent intent = getIntent();
//        String description = intent.getStringExtra("description");
//        textViewDisplayPath.setText(description);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        FragmentHindi fragmentHindi = new FragmentHindi();
        FragmentHindi fragmentEnglish = new FragmentHindi();
        Intent intent = getIntent();
        String pos = intent.getStringExtra("id");
        Bundle bundle = new Bundle();
        bundle.putString("position",pos);
        fragmentHindi.setArguments(bundle);
        fragmentEnglish.setArguments(bundle);
        adapter.addFragment(fragmentHindi, "Hindi");
        adapter.addFragment(fragmentEnglish, "English");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
