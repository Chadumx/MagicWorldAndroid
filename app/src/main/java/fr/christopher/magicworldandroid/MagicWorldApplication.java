package fr.christopher.magicworldandroid;

import android.app.Application;

public class MagicWorldApplication extends Application {

    private static MagicWorldApplication sInstance;

    public static MagicWorldApplication getInstance(){

        return sInstance;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
