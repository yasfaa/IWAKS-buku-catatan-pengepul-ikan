package com.wam.iwaksbukucatatanpengepulikan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wam.iwaksbukucatatanpengepulikan.ui.Fragments.DashboardFragment;
import com.wam.iwaksbukucatatanpengepulikan.ui.Fragments.FishFragment;
import com.wam.iwaksbukucatatanpengepulikan.ui.Fragments.TransactionFragment;
import com.wam.iwaksbukucatatanpengepulikan.R;
import com.wam.iwaksbukucatatanpengepulikan.model.Iwak;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Iwak> list = new ArrayList<>();
    private FirebaseUser firebaseUser;

    private static final String LOG_TAG =
            MainActivity2.class.getSimpleName();

    BottomNavigationView bottomNavigationView;
    DashboardFragment dashboardFragment = new DashboardFragment();
    FishFragment fishFragment;
    TransactionFragment transactionFragment = new TransactionFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_main);
        fishFragment = new FishFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,dashboardFragment).commit();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboardFragment).commit();
                        return true;

                    case R.id.page_2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fishFragment).commit();
                        return true;

                    case R.id.page_3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, transactionFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
    public void openPageBeli(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivityBeli.class);
        startActivity(intent);
    }
    public void openPageBeliRiwayat(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivityBeliRiwayat.class);
        startActivity(intent);
    }
    public void openPageJual(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivityJual.class);
        startActivity(intent);
    }
    public void openPageJualRiwayat(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivityJualRiwayat.class);
        startActivity(intent);
    }
    public void openPageInfo(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivityInfo.class);
        startActivity(intent);
    }
    public void openPageUser(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivityUser.class);
        startActivity(intent);
    }
}