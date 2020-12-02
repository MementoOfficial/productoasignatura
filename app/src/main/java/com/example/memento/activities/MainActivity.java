package com.example.memento.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.memento.R;
import com.example.memento.activities.LogIn;
import com.example.memento.data.UserConfig;
import com.example.memento.model.UserModel;

import java.security.InvalidParameterException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup(){
        setupActions();
    }

    private void setupActions() {
        Button btnStart = findViewById(R.id.main_button);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignUp();
            }
        });
    }

    private void navigateToSignUp(){
        saveFirstStart();
        Intent intent = new Intent(this, SignUp.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void saveFirstStart() {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setIsFirstTime(false);
    }

}