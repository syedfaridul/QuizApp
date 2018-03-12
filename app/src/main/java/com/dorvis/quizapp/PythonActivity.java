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

import com.dorvis.quizapp.activitiesresult.PythonResultActivity;
import com.dorvis.quizapp.model.Question3;
import com.dorvis.quizapp.sql.AndyDatabaseHelper;

import java.util.List;

public class PythonActivity extends AppCompatActivity {
    List<Question3> quesList;
    int score=0;
    int qid=0;
    Question3 currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private ImageView backarr_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
        backarr_img = (ImageView)findViewById(R.id.faq_back_python);
        backarr_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AndyDatabaseHelper db = new AndyDatabaseHelper(this);
        quesList = db.getAllQuestionsss();
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
                Log.d("youans",currentQ.getpANSWER()+" "+answer.getText().toString());
                if (currentQ.getpANSWER().equals(answer.getText())){
                    score ++;
                    Log.d("score","your score"+score);

                }
                if (qid<10){
                    currentQ = quesList.get(qid);
                    setQuestionView();
                }else {
                    Intent intent = new Intent(PythonActivity.this,PythonResultActivity.class);
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
        txtQuestion.setText(currentQ.getPythonQUESTION());
        rda.setText(currentQ.getpOPTA());
        rdb.setText(currentQ.getpOPTB());
        rdc.setText(currentQ.getpOPTC());
        qid++;

    }
}
