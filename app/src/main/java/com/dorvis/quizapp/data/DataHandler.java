package com.dorvis.quizapp.data;

import android.support.v7.util.SortedList;

import java.util.List;
/**
 * Data layer abstraction. All data related communication should happen via this interface. This
 * is the only point of interaction with shared preferences, local sqlite database, firebase and
 * network
 *
 * @author Sainath
 */


public interface DataHandler {
    /**
     * Saves current user's data on remote database. All the paramters are read from local store
     * so no need to pass any paramters.
     *
     * @param callback callback for status of the operation
     */
    void setUserInfo(SortedList.Callback<Void> callback);
}
