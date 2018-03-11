package com.dorvis.quizapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dorvis.quizapp.AndroidActivity;
import com.dorvis.quizapp.CProgramActivity;
import com.dorvis.quizapp.JavaActivity;
import com.dorvis.quizapp.NavigationActivity;
import com.dorvis.quizapp.activities.NewsActivity;
import com.dorvis.quizapp.PythonActivity;
import com.dorvis.quizapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FirstHomeFragment extends Fragment {
   // private SessionManager sessionManager;

    //AdView adView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.fragment_first_home, container, false);

        /*MobileAds.initialize(getActivity().getApplicationContext(), "ca-app-pub-9900811016341257~3358203779");
        adView = (AdView)view.findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);*/
            ImageView imageViewQuiz = (ImageView) view.findViewById(R.id.dq_imageView);
            ImageView imageViewinterview = (ImageView) view.findViewById(R.id.interview_img);
            ImageView imageViewTechNews = (ImageView) view.findViewById(R.id.technews_img);
            ImageView imageViewNotification = (ImageView) view.findViewById(R.id.notification_img);
            ImageView imageViewAndroid = (ImageView) view.findViewById(R.id.imageview_andy);
            ImageView imageViewPython = (ImageView) view.findViewById(R.id.imageView_python);
            ImageView imageViewJava = (ImageView) view.findViewById(R.id.img_java);

            ImageView imageViewCprogram = (ImageView) view.findViewById(R.id.imageView_cprogram);
            imageViewinterview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    convertToInterviewFragment();

                }
            });
            //call all submenu item daily quiz
            imageViewQuiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    convertToDailyFragment();

                }
            });
            //call technews activity
            imageViewTechNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    convertToTechNewsFragment();
                }
            });

            //call notification activity
            imageViewNotification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    convertToNotifyFragment();
                }
            });
            //Call AndroidActivity
            imageViewAndroid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), AndroidActivity.class);
                    startActivity(intent);

                }
            });
            //call PythonActivity
            imageViewPython.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), PythonActivity.class);
                    startActivity(intent);
                }
            });
            //call JavaActivity
            imageViewJava.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), JavaActivity.class);
                    startActivity(intent);
                }
            });

            //Call CprogramActivity
            imageViewCprogram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), CProgramActivity.class);
                    startActivity(intent);

                }
            });


            //calling PythonActivity


            return view;



    }

    // activity_navigation.xml inside file we change the FrameLayout using the containerView id
    // dailyquiz fragment call method
    private void convertToDailyFragment(){
       ToDoDailyQuizFragment newGamefragment = new ToDoDailyQuizFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void convertToInterviewFragment(){
        ToDoInterviewFragment toDoInterviewFragment = new ToDoInterviewFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView,toDoInterviewFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void convertToTechNewsFragment(){
        Intent intent = new Intent(getActivity().getApplicationContext(), NewsActivity.class);
        startActivity(intent);
    }


    private void convertToNotifyFragment() {
       ToDoNotificationFragment toDoNotificationFragment = new ToDoNotificationFragment();
       FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.containerView,toDoNotificationFragment);
       fragmentTransaction.addToBackStack(null);
       fragmentTransaction.commit();
    }




}
