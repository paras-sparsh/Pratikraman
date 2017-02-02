package com.example.home.pratikraman_14.HomePage.SubPaths;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.home.pratikraman_14.HomePage.ExpandableListviewAdapter;
import com.example.home.pratikraman_14.HomePage.Parts;
import com.example.home.pratikraman_14.HomePage.Path;
import com.example.home.pratikraman_14.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpandedNavigationDrawer extends AppCompatActivity {
    RecyclerView recyclerViewNavBar;
    ArrayList<Parts> parts;
    ArrayList<Path> parentList;
    Bundle mySavedInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mySavedInstance = savedInstanceState;
        parts = getIntent().getParcelableArrayListExtra("list");
        parentList = getIntent().getParcelableArrayListExtra("parentTitles");
        recyclerViewNavBar = (RecyclerView) findViewById(R.id.recyclerViewNavigationBar);
        ExpandableListviewAdapter expandableListviewAdapter;
        try {
            expandableListviewAdapter = new ExpandableListviewAdapter(this,parts,parentList);
            recyclerViewNavBar.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewNavBar.setAdapter(expandableListviewAdapter);
        }
        catch (NullPointerException exception){
            exception.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelableArrayList("listActivity",parts);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        parts = savedInstanceState.getParcelableArrayList("listActivity");

    }
}
