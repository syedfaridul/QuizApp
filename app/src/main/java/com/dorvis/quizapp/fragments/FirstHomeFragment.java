package com.dorvis.quizapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.dorvis.quizapp.R;

public class FirstHomeFragment extends Fragment  {
    Button button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_home,container,false);
        Button newGameButton = (Button) view.findViewById(R.id.dailyquiz_buttton);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView2);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragment();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                swapFragment1();
            }
        });
        return view;

    }

    private void swapFragment1() {
        SignOutFragment newGamefragment = new SignOutFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapFragment(){
       ToDoDailyQuizFragment newGamefragment = new ToDoDailyQuizFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
