package com.dorvis.quizapp.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dorvis.quizapp.NavigationActivity;
import com.dorvis.quizapp.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*https://androidclarified.com/google-signin-android-example/*/
public class SignInActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    public static final int GOOGLE_SIGNIN_CODE= 777;
    @Bind(R.id.btnSignIn)
    SignInButton btnSignIn;
   /* this object request to google for infomation which information you want define as DEFAULT_SIGN_IN
     only user name emial prifile photo requestEmail(), requestTokenId() etc.*/
    private GoogleSignInOptions gso;
    //
    private GoogleSignInClient mGoogleSignInClient;
    private String GOOGLE_ACCOUNT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        btnSignIn.setSize(SignInButton.SIZE_STANDARD);
        btnSignIn.setColorScheme(SignInButton.COLOR_LIGHT);
    }

    @OnClick(R.id.btnSignIn)
    public void onViewClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnSignIn:
                signIn();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
       /* if (account != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            onLoggedIn(account);
        } else {
            Log.d(TAG, "Not logged in");
        }*/

    }

    private void updateUI(@Nullable GoogleSignInAccount account) {
        if (account != null) {
            Log.d(TAG, "updateUI: " + account.getDisplayName());
            findViewById(R.id.btnSignIn).setVisibility(View.GONE);
        } else {
            Log.d(TAG, "updateUI: ");
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, GOOGLE_SIGNIN_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
               super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == GOOGLE_SIGNIN_CODE) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }


   private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
       try {
           GoogleSignInAccount account = completedTask.getResult(ApiException.class);

           // Signed in successfully, show authenticated UI.
           updateUI(account);
       } catch (ApiException e) {
           // The ApiException status code indicates the detailed failure reason.
           // Please refer to the GoogleSignInStatusCodes class reference for more information.
           Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
           updateUI(null);
       }
   }

}
