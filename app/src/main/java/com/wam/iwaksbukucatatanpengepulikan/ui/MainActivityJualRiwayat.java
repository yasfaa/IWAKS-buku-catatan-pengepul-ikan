package com.wam.iwaksbukucatatanpengepulikan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wam.iwaksbukucatatanpengepulikan.R;

public class MainActivityJualRiwayat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jual_riwayat);
    }
    private static final String LOG_TAG =
            MainActivityJualRiwayat.class.getSimpleName();

    public void backButton(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}