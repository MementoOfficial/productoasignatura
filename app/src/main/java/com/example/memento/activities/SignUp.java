package com.example.memento.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.memento.R;
import com.example.memento.activities.Notes;

public class SignUp extends AppCompatActivity {

    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button registrarse = (Button) findViewById(R.id.registrarse_signUp);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iniciar();
            }
        });
    }

    private void Iniciar(){

        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }
}