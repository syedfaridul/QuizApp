package com.dorvis.quizapp.subactivities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dorvis.quizapp.R;

public class ToDoNotificationActivity extends AppCompatActivity {
    private ImageView notfiy_imageview;
    private ImageView iv_FAQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_notification);
        notfiy_imageview = (ImageView)findViewById(R.id.notify_imageview);
        iv_FAQ =(ImageView)findViewById(R.id.faq_back_arrow);

        iv_FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    public void notify(View view) {

        NotificationManager nManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.examen1);

        builder.setContentTitle("Examen");

        builder.setContentText("new Quiz added");

        builder.setSubText("Android tutorial is coming...");

        Bitmap bmp= BitmapFactory.decodeResource(getResources(),
                R.drawable.examen1);

        builder.setLargeIcon(bmp);

        Intent i = new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),DailyQuizActivity.class));

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,i,0);

        builder.setContentIntent(pendingIntent);
        nManager.notify(1,builder.build());
    }
}
