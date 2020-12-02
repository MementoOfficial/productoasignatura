package com.example.memento.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.memento.R;
import com.example.memento.data.UserConfig;
import com.example.memento.helpers.ItemTapListener;
import com.example.memento.model.UserModel;

import java.security.InvalidParameterException;


public class LogIn extends AppCompatActivity implements ItemTapListener {

    public static final String USER_KEY = "USER";
    public static final String PASSWORD_KEY = "PASSWORD";

    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setup();
    }

    private void setup() {
        rootView = findViewById(R.id.ly_root);
        setupViewFromData();
    }

    private void setupViewFromData() {
        Intent startIntent = getIntent();
        if(startIntent == null) {
            Toast.makeText(
                    this,
                    "Algo salió mal al obtener los datos :(",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        UserModel userModel = getUserModelFromSources(startIntent.getExtras());

        if(getSupportActionBar() != null) {
            String fullname = TextUtils.isEmpty(userModel.getFullname()) ?
                    "Usuario" : userModel.getFullname();
            getSupportActionBar()
                    .setTitle(getString(R.string.welcome_user_title, fullname));
        }

        if(TextUtils.isEmpty(userModel.getPassword())) {
            Toast.makeText(
                    this,
                    R.string.cannot_get_password,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }


    @NonNull
    private UserModel getUserModelFromSources(Bundle extras) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        final UserModel user = userConfig.getUser();
        if(user != null) {
            return user;
        }
        if(extras == null) {
            throw new InvalidParameterException("Extras");
        }
        return new UserModel(extras.getString(USER_KEY), extras.getString(PASSWORD_KEY));
    }

    @Override
    public void onItemTap(View view, int position) {

    }

}