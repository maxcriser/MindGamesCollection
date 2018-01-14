package com.example.mvmax.mindgames.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.base.BaseActivity;

@SuppressLint("Registered")
public class GameActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);

    }
}