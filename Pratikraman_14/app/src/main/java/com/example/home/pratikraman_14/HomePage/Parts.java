package com.example.home.pratikraman_14.HomePage;

import android.os.Parcel;
import android.os.Parcelable;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.ArrayList;
import java.util.List;

public class Parts implements Parent<Path>,android.os.Parcelable {
    private List<Path> paths;
    int isExpandable;

    public Parts(List paths, int isExpandable) {
        this.paths = paths;
        this.isExpandable = isExpandable;
    }

    public Parts(Parcel in){
        this.paths = new ArrayList<Path>();
        in.readTypedList(paths,Path.CREATOR);
        this.isExpandable = in.readInt();
    }

    public static final Creator<Parts> CREATOR = new Creator<Parts>() {
        @Override
        public Parts createFromParcel(Parcel in) {
            return new Parts(in);
        }

        @Override
        public Parts[] newArray(int size) {
            return new Parts[size];
        }
    };

    @Override
    public List getChildList(){
        return  paths;
    }

    @Override
    public  boolean isInitiallyExpanded(){
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(paths);
        dest.writeInt(isExpandable);
    }
}
