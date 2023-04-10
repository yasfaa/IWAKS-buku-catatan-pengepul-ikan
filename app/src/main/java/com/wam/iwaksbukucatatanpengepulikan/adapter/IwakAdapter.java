package com.wam.iwaksbukucatatanpengepulikan.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.wam.iwaksbukucatatanpengepulikan.model.Iwak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IwakAdapter extends RecyclerView.Adapter<IwakAdapter.ListViewHolder> {
    private ArrayList<Iwak> list;
    private Activity activity;
    FirebaseFirestore db;
    private String iwakID;
    private String iwakName;
    private String imageView;
    private String iwakHarga;
    private String iwakHargaJual;




    public IwakAdapter(ArrayList<Iwak> list) {
        this.list = list;
        this.activity = activity;
        db = FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_iwak, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Iwak iwak = list.get(position);
        Glide.with(holder.itemView.getContext())
                .load(iwak.getFoto_Iwak())
                .apply(new RequestOptions().override(109, 104))
                .into(holder.imageView);
        holder.iwakName.setText(iwak.getNama_Iwak());
        holder.iwakHarga.setText("Harga : " + iwak.getHarga_Iwak());
        holder.iwakHargaJual.setText("Harga Jual : " + iwak.getHarga_Jual());
        holder.stock.setText(String.valueOf(iwak.getStock()) + " Pcs");

        holder.ll_row_iwak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bikin firebase disini setelah itu ke
                lemparFirestore(iwakID,iwakName,imageView,iwakHarga,iwakHargaJual);
            }
        });
    }

    private void lemparFirestore(String iwakID,String namaIwak,String imageView,String iwakharga,String iwakHargaJual) {
        Map<String,Object> keranjang = new HashMap<>();
        keranjang.put("iwakName", namaIwak);
        keranjang.put("iwakPicture", imageView);
        keranjang.put("iwakHarga", iwakharga);
        keranjang.put("iwakHargaJual", iwakHargaJual);

        db.collection("keranjang").document(iwakID)
                .set(keranjang)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity.getApplicationContext(), "Iwak sudah di keranjang",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_row_iwak;
        ImageView imageView;
        TextView iwakName;
        TextView iwakHarga;
        TextView iwakHargaJual;
        TextView stock;
        ImageView tambah,kurang;
        TextView jumlah;

        int kuantitas = 1;


        public ListViewHolder(@NonNull View itemview) {
            super(itemview);
            ll_row_iwak = itemview.findViewById(R.id.ll_row_iwak);
            imageView = itemview.findViewById(R.id.img_item_iwak);
            iwakName = itemview.findViewById(R.id.tv_nama);
            iwakHarga = itemview.findViewById(R.id.tv_hargaPasar);
            iwakHargaJual = itemview.findViewById(R.id.tv_hargaJual);
            stock = itemview.findViewById(R.id.tv_stock_barang);
            tambah = itemview.findViewById(R.id.tambah);
            kurang = itemview.findViewById(R.id.kurang);
            jumlah = itemview.findViewById(R.id.keranjang_jumlah);

        }
    }




}
