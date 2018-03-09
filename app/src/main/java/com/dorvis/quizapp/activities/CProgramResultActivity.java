package com.dorvis.quizapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dorvis.quizapp.NavigationActivity;
import com.dorvis.quizapp.R;

public class CProgramResultActivity extends AppCompatActivity {
    TextView txt;
    ImageView back_imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprogram_result);
        back_imageView = (ImageView)findViewById(R.id.faq_back_arrow) ;
        back_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication().getApplicationContext(),NavigationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        txt=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);

        switch (score)
        {
            case 1: txt.setText("You scored 10%, Keep learning");
                break;
            case 2: txt.setText("You scored 20%, Keep learning");
                break;
            case 3: txt.setText("You have 30%, Keep learning");
                break;
            case 4: txt.setText("You have 40%, Study it");
                break;
            case 5: txt.setText("You have 50%, Good attempt");
                break;
            case 6:txt.setText("You have 60% ,Good");
                break;
            case 7:txt.setText(" you have 70%, better");
                break;
            case 8:txt.setText("you have 80%,best");
                break;
            case 9:txt.setText("you have 90%, Excellent");
                break;
            case 10: txt.setText("you have 100%, Good luck");
                break;
        }
    }



}

