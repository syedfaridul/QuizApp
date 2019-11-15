package com.dorvis.quizapp.ui.login;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.dorvis.quizapp.data.local.db.ExamenQuizDatabase;
import com.dorvis.quizapp.data.local.db.dao.UserDao;
import com.dorvis.quizapp.data.models.User;

import java.util.List;

public class SignInRepository {
private UserDao userDao;
private LiveData<List<User>> getUserDetails;

    public SignInRepository(Application application) {
        ExamenQuizDatabase examenQuizDatabase = ExamenQuizDatabase.getInstance(application);
        userDao = examenQuizDatabase.userDao();
        getUserDetails = userDao.getUser();
    }

    public LiveData<List<User>> getGetUserDetails() {
        return getUserDetails;
    }

    public void insert(User user){
        new InsertEmpAsyncTask(userDao).execute(user);
    }

    public void update(User user){
        new UpdateEmpAsyncTask(userDao).execute(user);
    }

    public static class InsertEmpAsyncTask extends AsyncTask<User,Void,Void> {
        private UserDao userDao;

        public InsertEmpAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }


        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users[0]);
            return null;
        }
    }

    public static class UpdateEmpAsyncTask extends AsyncTask<Void,Void,Void>{
        private UserDao userDao;

        public UpdateEmpAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        public void execute(User user) {
            userDao.updateUser(user);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

    }
}
