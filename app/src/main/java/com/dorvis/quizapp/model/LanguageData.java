package com.dorvis.quizapp.model;

/**
 * Created by sai on 4/2/18.
 */

public class LanguageData {

    private int imageLanguage;
    private String titleLanguage;

    public LanguageData(int imageLanguage, String titleLanguage) {
        this.imageLanguage = imageLanguage;
        this.titleLanguage = titleLanguage;
    }

    public int getImageLanguage() {
        return imageLanguage;
    }

    public void setImageLanguage(int imageLanguage) {
        this.imageLanguage = imageLanguage;
    }

    public String getTitleLanguage() {
        return titleLanguage;
    }

    public void setTitleLanguage(String titleLanguage) {
        this.titleLanguage = titleLanguage;
    }
}
