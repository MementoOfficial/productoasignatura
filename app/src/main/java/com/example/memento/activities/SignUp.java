package com.example.memento.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.memento.R;
import com.example.memento.activities.Notes;
import com.example.memento.data.UserConfig;
import com.example.memento.model.UserModel;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    TextInputLayout tilUser, tilPassword, tilEmail;
    EditText eUser, ePassword, eEmail;
    UserModel userModel;

    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setup();
    }

    private void setup() {
        tilUser = findViewById(R.id.eUser);
        tilEmail = findViewById(R.id.eEmail);
        tilPassword = findViewById(R.id.ePassword);

        eUser = tilUser.getEditText();
        eEmail = tilEmail.getEditText();
        ePassword = tilPassword.getEditText();

        Button registrarse = findViewById(R.id.registrarse_signUp);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        if(!validateFields()) {
            return;
        }
        userModel = new UserModel(eUser.getText().toString(), ePassword.getText().toString());
        saveUser(userModel);
        navigateToMain(userModel);
    }

    private void saveUser(UserModel user) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setUser(user);
    }

    private void navigateToMain(UserModel user) {
        Intent intent = new Intent(this, Notes.class);
        //la proxima activity ahora será la primera en el back stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(LogIn.USER_KEY, user.getFullname());
        intent.putExtra(LogIn.PASSWORD_KEY, user.getPassword());
        startActivity(intent);
    }

    private boolean validateFields() {
        if (eUser.getText() == null || TextUtils.isEmpty(eUser.getText().toString())) {
            eUser.setError(getString(R.string.user_error));
            return false;
        }
        if (eEmail.getText() == null || TextUtils.isEmpty(eEmail.getText().toString())) {
            eEmail.setError(getString(R.string.email_error));
            return false;
        }
        if (ePassword.getText() == null || TextUtils.isEmpty(ePassword.getText().toString())) {
            ePassword.setError(getString(R.string.password_error));
            return false;
        }
        showMessage("Todo bien, todo correcto, gracias!");
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();
    }

}