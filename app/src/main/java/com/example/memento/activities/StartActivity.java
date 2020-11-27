package com.example.memento.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.memento.activities.LogIn;
import com.example.memento.activities.MainActivity;
import com.example.memento.activities.Notes;
import com.example.memento.data.UserConfig;

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
                intent = new Intent(getBaseContext(), LogIn.class);
            }
        }
        startActivity(intent);
        finish();
    }
}