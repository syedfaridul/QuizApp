package com.dorvis.quizapp.data.local.prefs;

public class DataManager {
 private SharedPrefsHelper mSharedPrefsHelper;

    public DataManager(SharedPrefsHelper mSharedPrefsHelper) {
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }

    public void clear(){
        mSharedPrefsHelper.clear();
    }
   public void setLoggedIn(){
        mSharedPrefsHelper.setLoggedInMode(true);
   }
   public boolean getLoggedInMode(){
       return mSharedPrefsHelper.getLoggedInMode();
   }
   public void setEmailIn(String emailName){
        mSharedPrefsHelper.setEmailName(emailName);
   }
   public String getEmailIn(){
        return mSharedPrefsHelper.getEmailName();
   }
}
