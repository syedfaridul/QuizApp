package com.dorvis.quizapp.sql;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sai on 31/1/18.
 */

public class SessionManager {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public SessionManager(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin){
        editor.putBoolean("loggedInmode",logggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode", false);
    }
}
