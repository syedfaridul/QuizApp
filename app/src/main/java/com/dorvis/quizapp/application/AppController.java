package com.dorvis.quizapp.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.dorvis.quizapp.R;
import com.dorvis.quizapp.customs.CustomViewWithTypefaceSupport;
import com.dorvis.quizapp.customs.TextField;
import com.dorvis.quizapp.data.local.prefs.DataManager;
import com.dorvis.quizapp.data.local.prefs.SharedPrefsHelper;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppController extends Application {
    private DataManager dataManager;


    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Gotham-Medium.otf")
                .setFontAttrId(R.attr.fontPath)
                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                .build()
        );

                SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);
    }

}