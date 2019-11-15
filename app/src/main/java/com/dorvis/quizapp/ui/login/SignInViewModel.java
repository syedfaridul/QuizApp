package com.dorvis.quizapp.ui.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.dorvis.quizapp.data.models.User;

import java.util.List;

public class SignInViewModel extends AndroidViewModel {
  private SignInRepository signInRepository;
  private LiveData<List<User>> getUser;

    public SignInViewModel(Application application) {
        super(application);
        signInRepository  = new SignInRepository(application);
        getUser = signInRepository.getGetUserDetails();
    }
   public void insertUser(User user){
     signInRepository.insert(user);
   }
   public void updateUser(User user){
        signInRepository.update(user);
   }

    public LiveData<List<User>> getGetUser() {
        return getUser;
    }
}
