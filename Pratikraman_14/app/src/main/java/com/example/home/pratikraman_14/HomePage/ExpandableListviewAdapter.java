package com.example.home.pratikraman_14.HomePage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.icu.text.MessagePattern;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.example.home.pratikraman_14.HomePage.DisplayPath.DisplayPathActivity;
import com.example.home.pratikraman_14.R;
import com.bignerdranch.expandablerecyclerview.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ExpandableListviewAdapter extends
        ExpandableRecyclerAdapter<Parts, Path, ParentViewHolder, ChildViewHolder> implements ExpandableRecyclerAdapter.ExpandCollapseListener {
    private LayoutInflater inflator;
    private List<Parts> partsList;


    Context context;
    ArrayList<Path> parentTitles ;

    public ExpandableListviewAdapter(Context context, List<Parts> parentItemList, ArrayList<Path> parentTitles) {
        super(parentItemList);
        this.partsList = parentItemList;
        this.context = context;
        inflator = LayoutInflater.from(context);
        this.parentTitles = parentTitles;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View viewParent = inflator.inflate(R.layout.content_parent, parentViewGroup, false);
        setExpandCollapseListener(this);
        return new PartsViewHolder(viewParent);

    }

    @NonNull
    @Override
    public ChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View viewChild = inflator.inflate(R.layout.content_child, childViewGroup, false);
        return new PathViewHolder(viewChild);
    }

    @Override
    public void onBindParentViewHolder( ParentViewHolder partsViewHolder, final int parentPosition, @NonNull Parts parent) {
        PartsViewHolder holder=(PartsViewHolder)partsViewHolder;
        holder.tvPath.setText(parentTitles.get(parentPosition).title);
        if(parentTitles.get(parentPosition).description.length() > 0 || parentTitles.get(parentPosition).id.equals("5555")
                || parentTitles.get(parentPosition).id.equals("5556")
                || parentTitles.get(parentPosition).id.equals("5557")
                || parentTitles.get(parentPosition).id.equals("5558")
                || parentTitles.get(parentPosition).id.equals("5559")
                || parentTitles.get(parentPosition).id.equals("5560")
                || parentTitles.get(parentPosition).id.equals("5561")){
            holder.imageViewArrow.setVisibility(View.INVISIBLE);
            holder.tvPath.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(parentTitles.get(parentPosition).description.length() > 0 || parentTitles.get(parentPosition).id.equals("5555")
                                    || parentTitles.get(parentPosition).id.equals("5556")
                                    || parentTitles.get(parentPosition).id.equals("5557")
                                    || parentTitles.get(parentPosition).id.equals("5558")
                                    || parentTitles.get(parentPosition).id.equals("5559")
                                    || parentTitles.get(parentPosition).id.equals("5560")
                                    || parentTitles.get(parentPosition).id.equals("5561")) {
                                Intent intent = new Intent(context, DisplayPathActivity.class);
                                intent.putExtra("description",parentTitles.get(parentPosition).description);
                                intent.putExtra("id",parentTitles.get(parentPosition).getId());
                                context.startActivity(intent);
                            }

                        }
                    }
            );
        }

        else holder.imageViewArrow.setVisibility(View.VISIBLE);

    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, int parentPosition, final int childPosition, @NonNull Path child) {
        PathViewHolder holder=(PathViewHolder)childViewHolder;
        final List<Path> pathList=partsList.get(parentPosition).getChildList();
        for (int i = 0; i < (partsList.size()); i++) {
            holder.tvPath.setText(pathList.get(childPosition).title);
            holder.tvPath.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(context, DisplayPathActivity.class);
                                intent.putExtra("description", pathList.get(childPosition).description);
                                intent.putExtra("id", pathList.get(childPosition).getId());
                                context.startActivity(intent);
                        }
                    }
            );
        }

    }

    @Override
    public void onParentExpanded(int parentPosition){
       final Parts parts = partsList.get(parentPosition);
        collapseAllParents();
        expandParent(parts);
    }

    @Override
    public void onParentCollapsed(int parentPosition) {

    }

}
