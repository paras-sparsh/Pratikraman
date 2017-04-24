package com.example.home.pratikraman_14.HomePage.DisplayPath;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by roman on 23/4/17.
 */

public class MyService extends Service {
    MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        player.setLooping(true); // Set looping
//        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            int musicId = (int) intent.getExtras().get("musicId");
            mediaPlayer = MediaPlayer.create(this, musicId);
            mediaPlayer.start();
        }
        if((boolean)intent.getBooleanExtra("isPlaying",false) == false) {
            int musicId = (int) intent.getExtras().get("musicId");
            mediaPlayer = MediaPlayer.create(this, musicId);
            mediaPlayer.start();
        } else {
            onPause();
        }

        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }
    public void onPause() {
mediaPlayer.pause();
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onLowMemory() {

    }
}
