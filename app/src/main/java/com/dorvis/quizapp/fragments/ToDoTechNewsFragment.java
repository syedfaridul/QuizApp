package com.dorvis.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorvis.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoTechNewsFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_tech_news, container, false);
    }

}
