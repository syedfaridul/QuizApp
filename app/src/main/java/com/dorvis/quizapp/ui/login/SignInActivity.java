package com.dorvis.quizapp.ui.login;


import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dorvis.quizapp.NavigationActivity;
import com.dorvis.quizapp.R;
import com.dorvis.quizapp.application.AppController;
import com.dorvis.quizapp.data.local.prefs.DataManager;
import com.dorvis.quizapp.data.local.prefs.SharedPrefsHelper;
import com.dorvis.quizapp.data.models.User;
import com.dorvis.quizapp.utils.AppConstants;
import com.dorvis.quizapp.utils.Validation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SignInActivity extends AppCompatActivity {


    @Bind(R.id.tvBackArrow)
    TextView tvBackArrow;
    @Bind(R.id.tvAppTitle)
    TextView tvAppTitle;
    @Bind(R.id.etUserEmail)
    EditText etUserEmail;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btSignIn)
    Button btSignIn;
    @Bind(R.id.view)
    View view;
    @Bind(R.id.llVersionInfo)
    LinearLayout llVersionInfo;
    @Bind(R.id.linear_layout)
    LinearLayout linearLayout;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    private SignInViewModel signInViewModel;
    private String userEmail,userPassword;
    private String getUserName;
    private DataManager dataManager;
    private SharedPrefsHelper sharedPrefsHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        sharedPrefsHelper = new SharedPrefsHelper(this);
        dataManager = ((AppController) getApplication()).getDataManager();
        if (dataManager.getLoggedInMode()) {
            getUserName = dataManager.getEmailIn();
            Intent intent = new Intent(SignInActivity.this, NavigationActivity.class);
            intent.putExtra(AppConstants.EMAIL, getUserName);
            startActivity(intent);
            finish();
        }
        initView();

    }

    private void initView() {
        signInViewModel = ViewModelProviders.of(this).get(SignInViewModel.class);
    }

    @OnClick({R.id.tvBackArrow, R.id.btSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvBackArrow:
                exitApp();
                break;
            case R.id.btSignIn:
              if (checkValidation()){
                saveNewUser();
              }else {
                  Snackbar snackbar = Snackbar
                          .make(coordinatorLayout, "Please enter Field!", Snackbar.LENGTH_LONG);
                  snackbar.show();
              }
                break;
        }
    }

    private void saveNewUser() {
        userEmail = etUserEmail.getText().toString().trim();
        userPassword = etPassword.getText().toString().trim();
        signInViewModel.insertUser(new User(userEmail, userPassword));
        signInViewModel.getGetUser().observe(this, users -> {
            if (users != null) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Login Successfully", Snackbar.LENGTH_LONG);
                snackbar.show();
                Intent intent = new Intent(SignInActivity.this, NavigationActivity.class);
                intent.putExtra(AppConstants.EMAIL, userEmail);
                dataManager.setEmailIn(userEmail);
                startActivity(intent);
                finish();
            } else {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "something went wrong", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                snackbar.show();
            }
        });


    }

    private boolean checkValidation() {
        boolean ret = true;
        if (!Validation.hasText(etUserEmail)) ret = false;
        if (!Validation.hasText(etPassword)) ret = false;
        return  ret;
    }

    private void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Examen");
        builder
                .setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                      finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });
       AlertDialog alertDialog = builder.create();
       alertDialog.show();
    }
}