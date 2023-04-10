package com.wam.iwaksbukucatatanpengepulikan.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wam.iwaksbukucatatanpengepulikan.R;

public class TransactionFragment extends Fragment {
    private FirebaseUser firebaseUser;
    private TextView username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        username = view.findViewById(R.id.username);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!=null){
            username.setText(firebaseUser.getDisplayName());
        }else {
            username.setText("Login Gagal");
        }

        return view;
    }
}
