package com.dorvis.quizapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dorvis.quizapp.activities.ExperienceActivity;
import com.dorvis.quizapp.activities.FresherActivity;
import com.dorvis.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoInterviewFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_to_do_interview,container,false);
        Button fresher_bt = (Button)view.findViewById(R.id.fresher_button);
        Button experience_bt =(Button)view.findViewById(R.id.experience_button);
        Button technical_bt = (Button)view.findViewById(R.id.technical_button);

        fresher_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent = new Intent(getActivity().getApplicationContext(), FresherActivity.class);
             startActivity(intent);
            }
        });

        experience_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(getActivity().getApplicationContext(), ExperienceActivity.class);
              startActivity(intent);
            }
        });
        technical_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Coming soon....",Toast.LENGTH_SHORT).show();
            }
        });
        return view;


    }


}
