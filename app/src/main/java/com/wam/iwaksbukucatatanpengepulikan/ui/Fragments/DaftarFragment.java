package com.wam.iwaksbukucatatanpengepulikan.ui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.wam.iwaksbukucatatanpengepulikan.ui.MainActivity2;
import com.wam.iwaksbukucatatanpengepulikan.R;

public class DaftarFragment extends Fragment {
    private EditText etNama, etEmail, etPassword, etPasswordcon;
    private Button btnDaftar;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daftar, container, false);
        etNama = view.findViewById(R.id.editTextName);
        etEmail = view.findViewById(R.id.editTextEmail);
        etPassword = view.findViewById(R.id.editTextPassword);
        etPasswordcon = view.findViewById(R.id.editTextPasswordCon);
        btnDaftar = view.findViewById(R.id.Daftar_Button);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNama.getText().length()>0 && etEmail.getText().length()>0 && etPassword.getText().length()>0 && etPasswordcon.getText().length()>0){
                    if (etPassword.getText().toString().equals(etPasswordcon.getText().toString())){
                        daftar(etNama.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
                    } else {
                        Toast.makeText(getContext(), "Silahkan Masukkan Password Yang Sama!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Silahkan Isi Semua Data! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private void daftar(String nama, String email, String password){
       mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful() && task.getResult()!=null){
                   FirebaseUser firebaseUser = task.getResult().getUser();
                   if (firebaseUser!=null) {
                       UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                               .setDisplayName(nama).build();
                       firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                           }
                       });
                   } else {
                       Toast.makeText(getContext(), "Gagal Daftar Akun!",Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(getContext(), task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
               }
           }
       });
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
        startActivity(new Intent(getContext(), MainActivity2.class));
    }
}
