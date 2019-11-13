package com.dorvis.quizapp.ui.login;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public interface LoginViewContract {
    void specifyGoogleSignIn(GoogleSignInOptions gso);
    void startProfileActivity();
    Context getContext();
    void goToGallery ();
    void showToast(String mssg);
    void callFromVKSignIn(int requestCode, int resultCode, Intent data);
}
