package com.wam.iwaksbukucatatanpengepulikan.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wam.iwaksbukucatatanpengepulikan.R;

public class MainActivityUser extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView uname, email;
    private Button btnLogout;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_user);
        uname = findViewById(R.id.uname);
        email = findViewById(R.id.myEmail);
        btnLogout = findViewById(R.id.Logout_Button);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!=null){
            uname.setText(firebaseUser.getDisplayName());
            email.setText(firebaseUser.getEmail());
        }else {
            uname.setText("Login Gagal");
            email.setText("Login Gagal");
        }
    }

    private static final String LOG_TAG =
            MainActivityBeliRiwayat.class.getSimpleName();

    public void backButton(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openPageLogin(View view) {
        FirebaseAuth.getInstance().signOut();
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity0.class);
        startActivity(intent);
        finish();
    }
}