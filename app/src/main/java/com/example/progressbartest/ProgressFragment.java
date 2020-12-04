package com.example.progressbartest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgressFragment extends Fragment {
    private ProgressBar progressBar;
    private int i = 0;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.progress, container, false);


    }



    //   @Override
    //   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    //   super.onViewCreated(view, savedInstanceState);

    //    progressBar = view.findViewById(R.id.Pg_test);
    //    textView = view.findViewById(R.id.tv_test2);
    //    MainActivity MA = new MainActivity();
    //     MA.setProgress(i);
    //    progressBar.getProgress();
    //     textView.setText(i + "%");
    //   }

}

