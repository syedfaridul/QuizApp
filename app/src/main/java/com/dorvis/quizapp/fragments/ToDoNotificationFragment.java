package com.dorvis.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dorvis.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoNotificationFragment extends Fragment {
private ImageView notfiy_imageview;
private ImageView iv_FAQ;

    public ToDoNotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
       View  view= inflater.inflate(R.layout.fragment_to_do_notification, container, false);
       notfiy_imageview = (ImageView)view.findViewById(R.id.notify_imageview);
       iv_FAQ =(ImageView)view.findViewById(R.id.faq_back_arrow);


        return view;
    }

}
