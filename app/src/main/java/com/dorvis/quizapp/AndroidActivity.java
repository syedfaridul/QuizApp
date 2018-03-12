package com.dorvis.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dorvis.quizapp.activitiesresult.AndroidResultActivity;
import com.dorvis.quizapp.model.Question;
import com.dorvis.quizapp.sql.AndyDatabaseHelper;

import java.util.List;

public class AndroidActivity extends AppCompatActivity implements View.OnClickListener {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private ImageView backarr_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        backarr_img = (ImageView)findViewById(R.id.faq_back_android);
        backarr_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AndyDatabaseHelper d= new AndyDatabaseHelper(this);
        quesList = d.getAllQuestions();

        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(this);




    }



    @Override
    public void onClick(View v) {

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton answer =(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        radioGroup.clearCheck();
        Log.d("youans",currentQ.getANSWER()+""+answer.getText());

        if (currentQ.getANSWER().equals(answer.getText())){
            score ++;
            Log.d("score","your score"+score);

        }
        if (qid<10){
            currentQ=quesList.get(qid);
            setQuestionView();
        }
        else {
            Intent intent = new Intent(AndroidActivity.this,AndroidResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }


    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}