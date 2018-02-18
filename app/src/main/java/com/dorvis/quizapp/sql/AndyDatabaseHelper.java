package com.dorvis.quizapp.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dorvis.quizapp.model.Question;
import com.dorvis.quizapp.model.Question2;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by sai on 15/2/18.
 */


public class AndyDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "AndyDatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz.db";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    private static final String TABLE_JAVA = "java";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public AndyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = " CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addAndroidQuestions();
        String sql2 = " CREATE TABLE IF NOT EXISTS " + TABLE_JAVA + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql2);
       addJavaQuestions();





        //db.close();
    }

    private void addAndroidQuestions()
    {
        Question q1=new Question("If permissions are missing the application will get this at runtime","Parser", "SQLiteOpenHelper ", "Security Exception", "Security Exception");
        this.addQuestion(q1);
        Question q2=new Question("An open source standalone database", "SQLite", "BackupHelper", "NetworkInfo", "SQLite");
        this.addQuestion(q2);
        Question q3=new Question("Sharing of data in Android is done via?","Wi-Fi radio", "Service Content Provider","Ducking", "Service Content Provider" );
        this.addQuestion(q3);
        Question q4=new Question("Main class through which your application can access location services on Android", "LocationManager", "AttributeSet", "SQLiteOpenHelper","LocationManager");
        this.addQuestion(q4);
        Question q5=new Question("Android is?","NetworkInfo","GooglePlay","Linux Based","Linux Based");
        this.addQuestion(q5);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);

    }


    //getting quiz in to table
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        // Select All Query
        String selectQuery = " SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        Log.w((String) TAG,
                "Upgrading the database from version " + oldV + " to "+ newV);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JAVA);
        // Create tables again
        onCreate(db);
    }



    private void addJavaQuestions()
    {
        Question2 k1 = new Question2("Java language has support for which of the following types of comment ?","Block,Line and Javadoc", "Javadoc, Literal and String ", "Javadoc, Char and String", "Javadoc, Char and String");
        this.addQuestion1(k1);
        Question2 k2 = new Question2("Command to execute a compiled java program is","Javac ", "run  ", "Java", "Java");
        this.addQuestion1(k2);
        Question2 k3 = new Question2("I permissions are missing the application will get this at runtime","Parser", "SQLiteOpenHelper ", "Security Exception", "Security Exception");
        this.addQuestion1(k3);
        Question2 k4 = new Question2("I permissions are missing the application will get this at runtime","Parser", "SQLiteOpenHelper ", "Security Exception", "Security Exception");
        this.addQuestion1(k4);
        Question2 k5 = new Question2("I permissions are missing the application will get this at runtime","Parser", "SQLiteOpenHelper ", "Security Exception", "Security Exception");
        this.addQuestion1(k5);

    }
    public void addQuestion1(Question2 quest) {

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getJavaQUESTION());
        values.put(KEY_ANSWER, quest.getjANSWER());
        values.put(KEY_OPTA, quest.getjOPTA());
        values.put(KEY_OPTB, quest.getjOPTB());
        values.put(KEY_OPTC, quest.getjOPTC());
        // Inserting Row
        dbase.insert(TABLE_JAVA, null, values);

    }


    public List<Question2> getAllQuestionss() {

        List<Question2> questList = new ArrayList<Question2>();
        // Select All Query
        String selectQuery = " SELECT  * FROM " + TABLE_JAVA;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question2 quests = new Question2();
                quests.setJAVAID(cursor.getInt(0));
                quests.setJavaQUESTION(cursor.getString(1));
                quests.setjANSWER(cursor.getString(2));
                quests.setjOPTA(cursor.getString(3));
                quests.setjOPTB(cursor.getString(4));
                quests.setjOPTC(cursor.getString(5));
                questList.add(quests);
            } while (cursor.moveToNext());
        }
        // return quest list
        return questList;
    }

    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
    public int rowcounts()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_JAVA;
        SQLiteDatabase dbs = this.getWritableDatabase();
        Cursor cursor = dbs.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


}
