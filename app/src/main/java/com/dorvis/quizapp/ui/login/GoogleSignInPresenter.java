package com.dorvis.quizapp.ui.login;

import android.content.Intent;

public interface GoogleSignInPresenter {
    void createGoogleClient (SignInActivity loginView);
    void onStart();
    void signIn(SignInActivity loginView);
    void onActivityResult (SignInActivity loginView,int requestCode, int resultCode, Intent data);
    void onStop ();
    void onDestroy();
}
