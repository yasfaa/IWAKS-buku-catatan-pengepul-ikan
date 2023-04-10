package com.wam.iwaksbukucatatanpengepulikan.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.wam.iwaksbukucatatanpengepulikan.R;
import com.wam.iwaksbukucatatanpengepulikan.model.Keranjang;

import java.util.ArrayList;

public class KeranjangHistoryAdapter extends RecyclerView.Adapter<KeranjangHistoryAdapter.KeranjangHistoryViewHolder>{
        private ArrayList<Keranjang> listKeranjang;
        private FirebaseFirestore db = FirebaseFirestore.getInstance();
        private Activity activity;

        @NonNull
        @Override
        public KeranjangHistoryAdapter.KeranjangHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_keranjang_iwak,parent,false);
            return new KeranjangHistoryViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull KeranjangHistoryAdapter.KeranjangHistoryViewHolder holder, int position) {
            Keranjang keranjang = listKeranjang.get(position);
            Glide.with(holder.itemView.getContext())
                    .load(keranjang.getNama_Iwak())
                    .apply(new RequestOptions().override(109,104))
                    .into(holder.imageView);
            holder.iwakName.setText(keranjang.getNama_Iwak());
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class KeranjangHistoryViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView iwakName;
            TextView iwakHarga;
            TextView iwakHargaJual;
            TextView jumlah;
            TextView kuantitas;
            ImageView hapus;
            public KeranjangHistoryViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.keranjang_item_iwak);
                iwakName = itemView.findViewById(R.id.keranjang_nama);
                iwakHarga = itemView.findViewById(R.id.keranjang_hargaPasar);
                iwakHargaJual = itemView.findViewById(R.id.keranjang_hargaJual);
                jumlah = itemView.findViewById(R.id.keranjang_jumlah);
                kuantitas = itemView.findViewById(R.id.keranjang_jumlah);
                hapus = itemView.findViewById(R.id.hapus);

                hapus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hapusKeranjang(getAdapterPosition());
                    }
                });
            }
        }

    public void hapusKeranjang(int position){
        Keranjang item = listKeranjang.get(position);
        db.collection("keranjang").document(item.getId_iwak()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity,"Barang telah terhapus!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

