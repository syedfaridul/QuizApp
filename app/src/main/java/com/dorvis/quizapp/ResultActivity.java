package com.dorvis.quizapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);

        switch (score)
        {
            case 0: t.setText("You scored 0%, keep learning");
                break;
            case 1: t.setText("You have 20%, study better");
                break;
            case 2: t.setText("You have 40%, keep learning");
                break;
            case 3: t.setText("You have 60%, good attempt");
                break;
            case 4:t.setText("You have 80% Excellent.. maybe you have been reading a lot of Programming quiz");
                break;
            case 5:t.setText(" Whao, you have 100%, Excellent");
                break;
        }
    }



}

