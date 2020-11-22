package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button iniciarButton;
    private UserConfig userConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        iniciarButton = (Button) findViewById(R.id.main_button);

        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogIn();
            }
        });
    }

    private void LogIn(){
        userConfig.isFirstTime();
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    private void setup(){

        userConfig = new UserConfig(getApplicationContext());
        if (!userConfig.isFirstTime()){
            LogIn();
            finish();
        }
    }
}