package com.dorvis.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dorvis.quizapp.model.Question2;
import com.dorvis.quizapp.sql.AndyDatabaseHelper;

import java.util.List;

public class JavaActivity extends AppCompatActivity {
    List<Question2> quesList;
    int score=0;
    int qid=0;
    Question2 currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        AndyDatabaseHelper db = new AndyDatabaseHelper(this);
        quesList = db.getAllQuestionss();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer =(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                radioGroup.clearCheck();
                Log.d("youanss",currentQ.getjANSWER()+" "+answer.getText().toString());
                if (currentQ.getjANSWER().equals(answer.getText())){
                    score ++;
                    Log.d("score","your score"+score);

                }
                if (qid<5){
                    currentQ = quesList.get(qid);
                    setQuestionView();
                }else {
                    Intent intent = new Intent(JavaActivity.this,ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score",score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getJavaQUESTION());
        rda.setText(currentQ.getjOPTA());
        rdb.setText(currentQ.getjOPTB());
        rdc.setText(currentQ.getjOPTC());
        qid++;

    }
}
