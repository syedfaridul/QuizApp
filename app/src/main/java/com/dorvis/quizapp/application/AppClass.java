package com.dorvis.quizapp.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class AppClass extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this.getApplicationContext();
    }

    public static Context getAppContext(){
        return sContext;
    }
}