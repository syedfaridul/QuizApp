package com.dorvis.quizapp.model;

/**
 * Created by sai on 16/2/18.
 */

public class Python {

   
    public static final String TABLE = "Python";

    public static final String KEY_PythonId = "PythonId";
    public static final String KEY_Question = "Question";
    public static final String KEY_Answer = "Answer";
    public static final String KEY_OPTA ="Key_OPTA";
    public static final String KEY_OPTB ="Key_OPTB";
    public static final String KEY_OPTAC ="Key_OPTC";

    private String python_ID;
    private String key_Question;
    private String key_Answer;
    private String key_OPTA;
    private String key_OPTB;
    private String Key_OPTC;

    public String getPython_ID() {
        return python_ID;
    }

    public void setPython_ID(String python_ID) {
        this.python_ID = python_ID;
    }

    public String getKey_Question() {
        return key_Question;
    }

    public void setKey_Question(String key_Question) {
        this.key_Question = key_Question;
    }

    public String getKey_Answer() {
        return key_Answer;
    }

    public void setKey_Answer(String key_Answer) {
        this.key_Answer = key_Answer;
    }

    public String getKey_OPTA() {
        return key_OPTA;
    }

    public void setKey_OPTA(String key_OPTA) {
        this.key_OPTA = key_OPTA;
    }

    public String getKey_OPTB() {
        return key_OPTB;
    }

    public void setKey_OPTB(String key_OPTB) {
        this.key_OPTB = key_OPTB;
    }

    public String getKey_OPTC() {
        return Key_OPTC;
    }

    public void setKey_OPTC(String key_OPTC) {
        Key_OPTC = key_OPTC;
    }
}
