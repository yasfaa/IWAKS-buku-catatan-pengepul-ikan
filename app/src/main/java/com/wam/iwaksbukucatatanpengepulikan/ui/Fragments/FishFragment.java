package com.wam.iwaksbukucatatanpengepulikan.ui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.wam.iwaksbukucatatanpengepulikan.R;
import com.wam.iwaksbukucatatanpengepulikan.adapter.IwakAdapter;
import com.wam.iwaksbukucatatanpengepulikan.model.Iwak;
import com.wam.iwaksbukucatatanpengepulikan.ui.MainActivity2;
import com.wam.iwaksbukucatatanpengepulikan.ui.MainActivityBeli;

import java.util.ArrayList;

public class FishFragment extends Fragment {
    IwakAdapter adapter;
    private Spinner spinner;
    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private ImageView keranjang;
    private ArrayList<Iwak> list = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FishFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        imageButton = view.findViewById(R.id.keranjang);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FishFragment.this.getActivity(), MainActivityBeli.class);
                startActivity(myIntent);
            }
        });
        ambilData(view);
        return view;
    }

    private void ambilData(View view) {
        db.collection("Iwak").orderBy("nama_Iwak").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot item : task.getResult()) {
                        Iwak iwak = new Iwak();
                        iwak.setNama_Iwak((String) item.get("nama_Iwak"));
                        iwak.setFoto_Iwak((String) item.get("foto_Iwak"));
                        iwak.setHarga_Iwak(String.valueOf(item.get("harga_Iwak")));
                        iwak.setHarga_Jual(String.valueOf(item.get("harga_Jual")));
                        iwak.setStock((String.valueOf(item.get("stock"))));

                        list.add(iwak);
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    IwakAdapter adapter = new IwakAdapter(list);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }
}