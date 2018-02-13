package com.dorvis.quizapp.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dorvis.quizapp.model.Question;
import com.dorvis.quizapp.model.User;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by sai on 31/1/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";

    private static final String TABLE_USER = "user";

    // user table column name
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private SQLiteDatabase dbase;

    //android quiz table column
    public static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_QUES = "question";
    public static final String KEY_ANSWER = "answer"; //correct option
    public static final String KEY_OPTA= "opta"; //option a
    public static final String KEY_OPTB= "optb"; //option b
    public static final String KEY_OPTC= "optc"; //option c

//create user table
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

//create android quiz table
// SQL statement of the employees table creation
    private static final String CREATE_QUIZ_TABLE = "CREATE TABLE " + TABLE_QUEST + "("
        + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + KEY_QUES + " TEXT , "
        + KEY_ANSWER + " TEXT , "
        + KEY_OPTA + " TEXT , "
        + KEY_OPTB + " TEXT , "
        + KEY_OPTC + " REAL NOT NULL, "
        +");";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_QUIZ_TABLE);
        addQuestions();
        db.close();

    }
    private void addQuestions()
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to "+ newVersion);
        // clear all data
            db.execSQL(DROP_USER_TABLE);
            db.execSQL(TABLE_QUEST);
            onCreate(db);


        }

   public void addQuestion (Question question){
        ContentValues values = new ContentValues();
       values.put(KEY_QUES, question.getQUESTION());
       values.put(KEY_ANSWER, question.getANSWER());
       values.put(KEY_OPTA, question.getOPTA());
       values.put(KEY_OPTB, question.getOPTB());
       values.put(KEY_OPTC, question.getOPTC());
       // Inserting Row
       dbase.insert(TABLE_QUEST,null,values);
   }
   public List<Question>getAllQuestions(){
       List<Question> questionList = new ArrayList<Question>();

       // Select All Query
       String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
       dbase=this.getReadableDatabase();
       Cursor cursor = dbase.rawQuery(selectQuery, null);
       if (cursor.moveToFirst()){
           do {
               Question quest = new Question();
               quest.setID(cursor.getInt(0));
               quest.setQUESTION(cursor.getString(1));
               quest.setANSWER(cursor.getString(2));
               quest.setOPTA(cursor.getString(3));
               quest.setOPTB(cursor.getString(4));
               quest.setOPTC(cursor.getString(5));
               questionList.add(quest);
           }while (cursor.moveToNext());
       }

       return questionList;
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



    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }



}
