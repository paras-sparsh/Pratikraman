package com.example.home.pratikraman_14.HomePage.DisplayPath;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.home.pratikraman_14.HomePage.Path;
import com.example.home.pratikraman_14.R;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentHindi extends Fragment implements PositionUpdateInterface {
    static ArrayList<Path> completeList;
    CustomPagerAdapter mCustomPagerAdapter;
    static String id;
String position;
public FragmentHindi(){}
    public FragmentHindi(ArrayList<Path> completeList, String pos) {

        this.completeList = new ArrayList<>();
        for (int i = 0 ; i<completeList.size();i++){
            this.completeList.add(completeList.get(i)) ;
        }

        this.position = pos;
        //mViewPager = (ViewPager) findViewById(R.id.pager);

//        mViewPager.setAdapter(mCustomPagerAdapter);
//        mViewPager.setCurrentItem(getTheObject(pos));
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_path, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
//            String position = bundle.getString("position");
            setData(position);
        }
        setRetainInstance(true);
    }

    public void setData(String pos) {
        ViewPager viewPager = (ViewPager)getView().findViewById(R.id.view_pager);
    viewPager.setOffscreenPageLimit(1);
        mCustomPagerAdapter = new CustomPagerAdapter(getContext(), completeList);
        //viewPager.setAdapter(mCustomPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                getActivity().setTitle(completeList.get(position).getTitle());
                id = completeList.get(position).getId();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(getTheObject(pos));
        //try {

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public int getTheObject(String pos) {
        for (int i =0;i<completeList.size();i++){
            if (completeList.get(i).getId().equalsIgnoreCase(pos)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void setPosition(String pos) {

    }

    @Override
    public String getPosition() {
        return id;
    }
}