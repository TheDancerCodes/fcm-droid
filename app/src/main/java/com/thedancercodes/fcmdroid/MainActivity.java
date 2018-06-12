package com.thedancercodes.fcmdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "FCMExample: ";

    private String mFCMToken;
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: get the FCM instance default token

        // Firebase function call to retrieve the token from the server
        mFCMToken = FirebaseInstanceId.getInstance().getToken();

        tvMsg = (TextView)findViewById(R.id.textView2);

        // TODO: Log the token to debug output so we can copy it
        ((Button)findViewById(R.id.btnLogToken)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "FCM Droid Token: " + mFCMToken);
            }
        });

        // TODO: subscribe to a topic
        ((Button)findViewById(R.id.btnSubscribe)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // TODO: unsubscribe from a topic
        ((Button)findViewById(R.id.btnUnsubscribe)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // TODO: When the activity starts up, look for intent information
        // that may have been passed in from the Notification tap
        if (getIntent().getExtras() != null) {

            // String that will contain each of the keys that were passed in by the intent
            String launchMsg = "";

            // for loop to get the keySet for each one of the messages
            for (String key: getIntent().getExtras().keySet()) {

                // Create an object just to hold the value
                Object val = getIntent().getExtras().get(key);

                Log.d(TAG, "Key: " + key + " Value: " + val + "\n");

                launchMsg += "Key: " + key + " Value: " + val + "\n";
            }

            tvMsg.setText(launchMsg);
        }
        else {
            tvMsg.setText("No launch information");
        }
    }

}
