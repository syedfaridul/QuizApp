package com.dorvis.quizapp.model;

/**
 * Created by sai on 16/2/18.
 */

public class Question2 extends Question {
    private int JAVAID;
    private String JavaQUESTION;
    private String jOPTA;
    private String jOPTB;
    private String jOPTC;
    private String jANSWER;


    public Question2() {
        JAVAID = 0;
        JavaQUESTION = "";
        jOPTA = "";
        jOPTB = "";
        jOPTC = "";
        jANSWER = "";
    }

    public Question2(String quESTION, String opTA, String opTB, String opTC,
                     String anSWER) {

        JavaQUESTION = quESTION;
        jOPTA = opTA;
        jOPTB = opTB;
        jOPTC = opTC;
        jANSWER = anSWER;
    }

    public int getJAVAID() {
        return JAVAID;
    }

    public void setJAVAID(int JAVAID) {
        this.JAVAID = JAVAID;
    }

    public String getJavaQUESTION() {
        return JavaQUESTION;
    }

    public void setJavaQUESTION(String javaQUESTION) {
        JavaQUESTION = javaQUESTION;
    }

    public String getjOPTA() {
        return jOPTA;
    }

    public void setjOPTA(String jOPTA) {
        this.jOPTA = jOPTA;
    }

    public String getjOPTB() {
        return jOPTB;
    }

    public void setjOPTB(String jOPTB) {
        this.jOPTB = jOPTB;
    }

    public String getjOPTC() {
        return jOPTC;
    }

    public void setjOPTC(String jOPTC) {
        this.jOPTC = jOPTC;
    }

    public String getjANSWER() {
        return jANSWER;
    }

    public void setjANSWER(String jANSWER) {
        this.jANSWER = jANSWER;
    }
}