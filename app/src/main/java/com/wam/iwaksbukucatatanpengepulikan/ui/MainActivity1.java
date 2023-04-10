package com.wam.iwaksbukucatatanpengepulikan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wam.iwaksbukucatatanpengepulikan.ui.Fragments.DashboardFragment;
import com.wam.iwaksbukucatatanpengepulikan.ui.Fragments.FishFragment;
import com.wam.iwaksbukucatatanpengepulikan.ui.Fragments.GuestFragment;
import com.wam.iwaksbukucatatanpengepulikan.R;

public class MainActivity1 extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private static final String LOG_TAG =
            MainActivity1.class.getSimpleName();

    BottomNavigationView bottomNavigationView;
    DashboardFragment dashboardFragment = new DashboardFragment();
    FishFragment fishFragment = new FishFragment();
    GuestFragment guestFragment = new GuestFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_main);
        //fishFragment = new FishFragment(this.);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,dashboardFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboardFragment).commit();
                        return true;

                    case R.id.page_2:
//                        Log.e("Tes", "TES");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fishFragment).commit();
                        return true;

                    case R.id.page_3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, guestFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
    public void openPageLogin(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity0.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(),MainActivity2.class));
    }
}
