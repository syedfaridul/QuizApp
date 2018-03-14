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

public class JavaResultActivity extends AppCompatActivity {
    public TextView textViewHighscore;
    ImageView back_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_result);

        textViewHighscore=(TextView)findViewById(R.id.textview_result);

        back_imageView = (ImageView) findViewById(R.id.faq_back_arrow);
        back_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // getting result by bundle
        //get text view
        Bundle bundle = getIntent().getExtras();
        String test = bundle.getString("test");
        textViewHighscore.setText(test);
    }
}