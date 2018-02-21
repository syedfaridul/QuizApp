package com.dorvis.quizapp;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;


import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dorvis.quizapp.authentication.LoginActivity;
import com.dorvis.quizapp.fragments.FirstHomeFragment;
import com.dorvis.quizapp.fragments.ToDoNotificationFragment;

import java.io.File;


public class NavigationActivity extends AppCompatActivity {


    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    ImageView imageView;
    android.app.FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    //nav_header navigation view item
    ImageView profile_imgView;
    TextView username_txtview;
    // header.xml action bar item
    ImageView signin_img;
    //navigation menu floder
    ImageView imageView_Share;


    //home fragment imageview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        signin_img = (ImageView) findViewById(R.id.header_signin);
        username_txtview = (TextView) findViewById(R.id.userName_txtview);
        profile_imgView = (ImageView) findViewById(R.id.imageView_profile);

        signin_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });




        FragmentManager manager = this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new FirstHomeFragment()).commit();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        mNavigationView.removeHeaderView(null);

        mNavigationView.removeHeaderView(mNavigationView.getHeaderView(0));
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_navigation, null);
        mNavigationView.addHeaderView(header);


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                int id = item.getItemId();
                if (id == R.id.nav_sign_out) {
                    startActivity(new Intent(NavigationActivity.this, LoginActivity.class));

                } else if (id == R.id.nav_tech_news) {
                    startActivity(new Intent(NavigationActivity.this, NewsActivity.class));

                } else if (id == R.id.nav_notification) {
                    startActivity(new Intent(NavigationActivity.this, ToDoNotificationFragment.class));
                }else if (id == R.id.nav_share){

                }


                return false;
            }
        });


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


    }


}
