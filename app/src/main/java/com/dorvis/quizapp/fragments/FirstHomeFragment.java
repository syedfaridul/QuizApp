package com.dorvis.quizapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.dorvis.quizapp.R;

public class FirstHomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_home, container, false);

        ImageView imageViewQuiz =(ImageView)view.findViewById(R.id.dq_imageView);
        ImageView imageViewinterview =(ImageView)view.findViewById(R.id.interview_img);
        ImageView imageViewTechNews =(ImageView)view.findViewById(R.id.technews_img);
        ImageView imageViewNotification =(ImageView)view.findViewById(R.id.notification_img);
        CardView cardView = (CardView)view.findViewById(R.id.bankcardId);

        imageViewinterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convertToInterviewFragment();

            }
        });

        imageViewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertToDailyFragment();

            }
        });
        imageViewTechNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertToTechNewsFragment();
            }
        });


        imageViewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertToNotifyFragment();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToAndroidfragment();
            }
        });

        return view;



    }

    private void convertToAndroidfragment() {
        ToDoAndroidFragment toDoAndroidFragment = new ToDoAndroidFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView,toDoAndroidFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

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


    private void convertToTechNewsFragment() {
        ToDoTechNewsFragment toDoTechNewsFragment = new ToDoTechNewsFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView,toDoTechNewsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    private void convertToNotifyFragment() {
       ToDoNotificationFragment toDoNotificationFragment = new ToDoNotificationFragment();
       FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.containerView,toDoNotificationFragment);
       fragmentTransaction.addToBackStack(null);
       fragmentTransaction.commit();
    }

}
