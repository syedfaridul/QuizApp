package com.dorvis.quizapp.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.dorvis.quizapp.utils.AppConstants;

public class SharedPrefsHelper {
    public static final String MY_PREFS = "Examen_Prefs";
    public static final String EMAIL = "EMAIL";
    private static final String IS_LOG_IN = "IS_LOGGED_IN";

    private SharedPreferences mSharedPreferences;

    public SharedPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public boolean getLoggedInMode() {
        return mSharedPreferences.getBoolean(IS_LOG_IN, false);
    }

    public void setLoggedInMode(boolean loggedIn) {
        mSharedPreferences.edit().putBoolean(IS_LOG_IN, loggedIn).apply();
    }

    public String getEmailName(){
        return mSharedPreferences.getString(EMAIL, AppConstants.EMPTY);
    }
    public void setEmailName(String emailName){
        mSharedPreferences.edit().putString(EMAIL,emailName).apply();
    }

}
