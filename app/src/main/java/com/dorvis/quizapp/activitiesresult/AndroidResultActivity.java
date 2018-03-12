package com.dorvis.quizapp.activitiesresult;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dorvis.quizapp.NavigationActivity;
import com.dorvis.quizapp.R;

public class AndroidResultActivity extends AppCompatActivity  {
    TextView t;
    ImageView back_imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       back_imageView = (ImageView)findViewById(R.id.faq_back_arrow);
       back_imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               
               finish();
           }
       });
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
         t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);

        switch (score)
        {
            case 1: t.setText("You scored 10%, Keep learning");
                break;
            case 2: t.setText("You scored 20%, Keep learning");
                    break;
            case 3: t.setText("You have 30%, Keep learning");
                break;
            case 4: t.setText("You have 40%, Study it");
                break;
            case 5: t.setText("You have 50%, Good attempt");
                break;
            case 6:t.setText("You have 60% ,Good");
                break;
            case 7:t.setText(" you have 70%, better");
                break;
            case 8:t.setText("you have 80%,best");
                break;
            case 9: t.setText("you have 90%, Excellent");
                break;
            case 10: t.setText("you have 100%, Good luck");
                break;
        }
    }



}

