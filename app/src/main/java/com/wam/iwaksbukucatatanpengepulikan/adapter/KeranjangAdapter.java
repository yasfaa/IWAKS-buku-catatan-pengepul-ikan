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

public class KeranjangAdapter  extends RecyclerView.Adapter<KeranjangAdapter.KeranjangViewHolder> {
    private ArrayList<Keranjang> listKeranjang;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Activity activity;


    public KeranjangAdapter(ArrayList<Keranjang> list){
        this.listKeranjang = list;
    }

    @NonNull
    @Override
    public KeranjangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_keranjang_iwak,parent,false);
        return new KeranjangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangViewHolder holder, int position) {
        Keranjang keranjang = listKeranjang.get(position);
        Glide.with(holder.itemView.getContext())
                .load(keranjang.getNama_Iwak())
                .apply(new RequestOptions().override(109,104))
                .into(holder.imageView);
        holder.iwakName.setText(keranjang.getNama_Iwak());
    }

    @Override
    public int getItemCount() {
        return listKeranjang.size();
    }

    public class KeranjangViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView kurang;
        ImageView tambah;
        ImageView hapus;
        TextView iwakName;
        TextView iwakHarga;
        TextView iwakHargaJual;
        TextView jumlah;
        TextView kuantitas;
        public KeranjangViewHolder(View itemview) {
            super(itemview);
            imageView = itemview.findViewById(R.id.keranjang_item_iwak);
            kurang = itemview.findViewById(R.id.kurang);
            iwakName = itemview.findViewById(R.id.keranjang_nama);
            iwakHarga = itemview.findViewById(R.id.keranjang_hargaPasar);
            iwakHargaJual = itemview.findViewById(R.id.keranjang_hargaJual);
            jumlah = itemview.findViewById(R.id.keranjang_jumlah);
            kuantitas = itemview.findViewById(R.id.keranjang_jumlah);
            hapus = itemview.findViewById(R.id.hapus);

            jumlah.setText(String.valueOf(kuantitas));
            tambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kuantitas++;
                }
            });
            kurang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (int kuatitas = Integer.parseInt(kuantitas)<=0){
                        kuantitas=0;
                    } else {
                        kuantitas--;
                    }
                }
            });
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
