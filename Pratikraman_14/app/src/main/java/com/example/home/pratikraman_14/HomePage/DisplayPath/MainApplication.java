package com.example.home.pratikraman_14.HomePage.DisplayPath;

import android.app.Application;
import android.content.Context;

import com.example.home.pratikraman_14.HomePage.Helper.LocaleHelper;

/**
 * Created by home on 03/02/17.
 */

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
