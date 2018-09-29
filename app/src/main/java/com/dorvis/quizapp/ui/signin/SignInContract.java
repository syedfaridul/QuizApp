package com.dorvis.quizapp.ui.signin;

import com.dorvis.quizapp.ui.base.BasePresenter;
import com.dorvis.quizapp.ui.base.BaseView;

/**
 * Sign In Contract contract. Keeps SignIn Screen View and Presenter interfaces in one place.
 *
 * @Author Sainath
 */
public interface SignInContract {

    /**
     * SignIn View
     */
    interface View extends BaseView<Presenter>{

        void loginSuccess();

        void loginFailure(int statusCode,String message);

        void startSingIn();

        void navigateToProfile();

    }

    /**
     * SignIn Presenter
     */
    interface Presenter extends BasePresenter{
        void handleLoginRequest();

        void handleLoginSuccess(String email, String displayName,String photoUrl);

        void handleLoginFailure(int statusCode,String message);

    }

}
