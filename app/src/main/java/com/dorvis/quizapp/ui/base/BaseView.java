package com.dorvis.quizapp.ui.base;

public interface BaseView<T>{
    void setPresenter(T presenter);

    void showLoading();

    void hideLoading();

}
