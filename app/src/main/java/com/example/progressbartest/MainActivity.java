package com.example.progressbartest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.os.Bundle;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button button;
    private int i = 0;
    private TextView textView;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.Pg_test);
        button = findViewById(R.id.button_icr);
        textView = findViewById(R.id.tv_test2);
        button2 = findViewById(R.id.button_frag);
        progressBar.setMax(100);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setProgressBar();

    }

    public void setProgressBar() {
        if (i <= 90) {
            i += 10;
        }

        progressBar.setProgress(i);
        textView.setText(i + "%");
        //  i++;
        // progressBar.setProgress(i);
        //textView.setText(i + "%");

        if (i == 100) {
            i = 0;
            progressBar.setProgress(100);

        }
    }


        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View root;
                root = findViewById(R.id.rootview);
                getFragment();
            }
        });
    }


    public void getFragment() {
        ProgressFragment fragment;
            fragment = new ProgressFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.rootview, fragment);
            ft.commit();

    }
}