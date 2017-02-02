package com.example.home.pratikraman_14.HomePage;

import android.os.Parcel;
import android.os.Parcelable;

public class Path  implements Parcelable {
    String id;
    String title;
    String description;
    int musicFile;

    public Path(String id,String title,String description,int musicFile) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.musicFile = musicFile;
    }

    Path(Parcel in){
        this.id = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.musicFile = in.readInt();
    }

    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() {
        public Path createFromParcel(Parcel in)
        {
            return new Path(in);
        }
        public Path[] newArray(int size)
        {
            return new Path[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(musicFile);
    }

    public String getId(){ return id;}

    public String getTitle(){return title;}

    public String getDescription(){return description;}
    public int getMusicFile(){return musicFile;}

    public void setId(String id){this.id = id;}

    public void setTitle(String title){this.title = title;}
    public void setMusicFile(int musicFile){this.musicFile = musicFile;}

    public void setDescription(String description) {this.description = description;}
}
