package com.dorvis.quizapp.ui.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dorvis.quizapp.data.DataHandler;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View mView;
    private DataHandler mDataHandler;
    @Override
    public void handleLoginRequest() {

    }

    @Override
    public void handleLoginSuccess(String email, String displayName, String photoUrl) {

    }

    @Override
    public void handleLoginFailure(int statusCode, String message) {

    }

    @Override
    public void start(@Nullable Bundle extras) {

    }

    @Override
    public void destroy() {

    }
}
