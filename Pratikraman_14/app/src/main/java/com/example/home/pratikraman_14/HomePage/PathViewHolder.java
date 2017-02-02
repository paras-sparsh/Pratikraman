package com.example.home.pratikraman_14.HomePage;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.example.home.pratikraman_14.R;

public class PathViewHolder   extends ChildViewHolder {
    TextView tvPath;

    public PathViewHolder(View itemView){
        super(itemView);
        tvPath = (TextView) itemView.findViewById(R.id.textViewChild);
    }
}
