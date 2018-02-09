package com.dorvis.quizapp;

import android.app.FragmentTransaction;
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

import com.dorvis.quizapp.authentication.LoginActivity;
import com.dorvis.quizapp.fragments.FirstHomeFragment;


public class NavigationActivity extends AppCompatActivity {


    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    ImageView imageView;
    android.app.FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;



   //login and signup ui here

    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

         imageView = (ImageView)findViewById(R.id.header_signin);

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




                return false;
            }
        });



        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();




    }



}
