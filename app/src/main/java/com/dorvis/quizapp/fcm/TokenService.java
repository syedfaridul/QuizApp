package com.dorvis.quizapp.fcm;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sai on 10/3/18.
 */

public class TokenService extends FirebaseInstanceIdService {
    private static final String TAG ="TokenService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.w("notification", refreshedToken);
        sendRegistrationToServer(refreshedToken);

       // Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


    private void sendRegistrationToServer(String token) {
    }
}
