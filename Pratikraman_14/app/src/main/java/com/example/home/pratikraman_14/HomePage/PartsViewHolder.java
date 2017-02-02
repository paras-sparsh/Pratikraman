package com.example.home.pratikraman_14.HomePage;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.example.home.pratikraman_14.R;


import static com.example.home.pratikraman_14.R.id.imageViewArrow;

public class PartsViewHolder  extends ParentViewHolder {
     TextView tvPath;
     ImageView imageViewArrow;

    public PartsViewHolder(View itemView){
        super(itemView);
        tvPath = (TextView) itemView.findViewById(R.id.textViewParent);
        imageViewArrow = (ImageView)itemView.findViewById(R.id.imageViewArrow);
    }

    @Override
    public void onExpansionToggled(final boolean expanded) {
        super.onExpansionToggled(expanded);
        if (isExpanded()){
            imageViewArrow.setImageResource(R.drawable.down_arrow);
        }
        else {
            imageViewArrow.setImageResource(R.drawable.up_arrow);
        }
    }

}
