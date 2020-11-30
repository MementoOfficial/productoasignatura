package com.example.memento.activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.memento.R;
import com.example.memento.activities.LogIn;
import com.example.memento.activities.MainActivity;
import com.example.memento.activities.Notes;
import com.example.memento.data.UserConfig;
import com.example.memento.notifications.MyNotificationPublisher;

public class StartActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchFirstActivity();
    }

    private void launchFirstActivity(){
        UserConfig userConfig = new UserConfig(getApplicationContext());
        Intent intent;

        if (userConfig.isFirstTime()){
            intent = new Intent(getBaseContext(), MainActivity.class);
        } else {
            if (userConfig.userExists()){
                intent = new Intent(getBaseContext(), Notes.class);
            } else {
                intent = new Intent(getBaseContext(), SignUp.class);
            }
        }
        startActivity(intent);
        finish();
    }

}