package com.dorvis.quizapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dorvis.quizapp.R;

public class AboutUsActivity extends AppCompatActivity {
  private ImageView backarrow_img;
      TextView txtview1,txtview2,txtview3;
      ImageView imageView_devProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        txtview1 = (TextView)findViewById(R.id.txtviewDescribe);
        txtview2 =(TextView)findViewById(R.id.txtViewContact);
        imageView_devProfile =(ImageView)findViewById(R.id.imgProfileDeveloper);
        txtview3  =(TextView)findViewById(R.id.txtViewName);

        backarrow_img = (ImageView)findViewById(R.id.faq_back_arrow);

        backarrow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
