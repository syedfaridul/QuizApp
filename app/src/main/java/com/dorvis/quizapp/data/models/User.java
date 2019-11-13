package com.dorvis.quizapp.data.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user_register")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String userName;
    private String userPassword;



    public User(String userName, String userPassword) {
        this.userName =userName;
        this.userPassword =userPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
