package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    private Button iniciarButton;
    private Button registrarseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        iniciarButton = (Button) findViewById(R.id.iniciar_logIn);

        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iniciar();
            }
        });

        registrarseButton = (Button) findViewById(R.id.registrarse_logIn);

        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrarse();
            }
        });
    }

    private void Iniciar(){
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }

    private void Registrarse(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}