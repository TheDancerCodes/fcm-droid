package com.thedancercodes.fcmdroid;


import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FCMDroidMsgService extends FirebaseMessagingService {
    private static final String TAG = "FCMDroidMsgService";

    @Override
    public void onMessageReceived(RemoteMessage theMessage) {

        // Log message data: Shows the ID of the person who sent the message
        Log.d(TAG, "Message received from: " + theMessage.getFrom());

        // Retrieve payload from the message and log that out:
        if (theMessage.getData().size() > 0) {
            Log.d(TAG, "Message size: " + theMessage.getData().size());

            // Log each key-value pair as well
            for (String key: theMessage.getData().keySet()) {
                Log.d(TAG, "key: " + key + "; data: " +
                    theMessage.getData().get(key));
            }
        }

    }

    // onDeletedMessage function is called if there are too many pending messages to send to
    // this client, Like more than 100.
    // Or if this client hasn't connected to FCM in a long time like more than a month.
    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }
}
