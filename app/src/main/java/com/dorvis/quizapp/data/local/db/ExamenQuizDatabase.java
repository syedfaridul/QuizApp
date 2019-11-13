package com.dorvis.quizapp.data.local.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dorvis.quizapp.data.local.db.dao.UserDao;
import com.dorvis.quizapp.data.models.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class ExamenQuizDatabase extends RoomDatabase {
 private static ExamenQuizDatabase  instance;
    public abstract UserDao userDao();

    public static synchronized ExamenQuizDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ExamenQuizDatabase.class, "examen_quiz_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    public static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

}
