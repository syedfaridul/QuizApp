package com.dorvis.quizapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dorvis.quizapp.AndroidActivity;
import com.dorvis.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoDailyQuizFragment extends Fragment {


    public ToDoDailyQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_to_do_daily_quiz, container, false);
        View view = inflater.inflate(R.layout.fragment_to_do_daily_quiz,container,false);

        ImageView img_android = (ImageView)view.findViewById(R.id.img_android);
        img_android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), AndroidActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    // activity_navigation.xml inside file we change the FrameLayout using the containerView id


}
