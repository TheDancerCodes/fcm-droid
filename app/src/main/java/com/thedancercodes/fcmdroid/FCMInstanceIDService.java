package com.thedancercodes.fcmdroid;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

// To handle messages when your app is in the foreground your app will need to provide a service
// that extends the FirebaseMessagingService class.
public class FCMInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FCMInstanceIDService";


    // onTokenRefresh() method is called whenever the device registration token changes.
    // This can happen in certain circumstances such as when the user clears their app data
    // or they uninstall and reinstall the app.
    @Override
    public void onTokenRefresh() {

        String newToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed Token: " + newToken);

        /*
         * NOTE: You would also usually send the updated token to your app server so you could
         * resume sending messages to this client when the token was refreshed.
         *
         * Now we're not using an app server in this example so I don't need to do that but
         * in a real world scenario you would probably need to send this to your app server.
         */
    }
}
