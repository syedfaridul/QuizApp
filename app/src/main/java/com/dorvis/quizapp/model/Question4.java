package com.dorvis.quizapp.model;

/**
 * Created by sai on 18/2/18.
 */

public class Question4 extends Question {
    private int CID;
    private String CQUESTION;
    private String cOPTA;
    private String cOPTB;
    private String cOPTC;
    private String cANSWER;


    public Question4() {
        CID = 0;
        CQUESTION = "";
        cOPTA = "";
        cOPTB = "";
        cOPTC = "";
        cANSWER = "";
    }

    public Question4(String questION, String oPTA, String oPTB, String oPTC,
                     String answER) {

       CQUESTION = questION;
        cOPTA = oPTA;
        cOPTB = oPTB;
        cOPTC = oPTC;
        cANSWER = answER;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getCQUESTION() {
        return CQUESTION;
    }

    public void setCQUESTION(String CQUESTION) {
        this.CQUESTION = CQUESTION;
    }

    public String getcOPTA() {
        return cOPTA;
    }

    public void setcOPTA(String cOPTA) {
        this.cOPTA = cOPTA;
    }

    public String getcOPTB() {
        return cOPTB;
    }

    public void setcOPTB(String cOPTB) {
        this.cOPTB = cOPTB;
    }

    public String getcOPTC() {
        return cOPTC;
    }

    public void setcOPTC(String cOPTC) {
        this.cOPTC = cOPTC;
    }

    public String getcANSWER() {
        return cANSWER;
    }

    public void setcANSWER(String cANSWER) {
        this.cANSWER = cANSWER;
    }
}
