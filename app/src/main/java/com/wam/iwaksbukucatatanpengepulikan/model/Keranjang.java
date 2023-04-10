package com.wam.iwaksbukucatatanpengepulikan.model;

public class Keranjang {
    private String nama_Iwak,harga_Iwak,Foto_Iwak,harga_Jual,id_iwak;
    private int harga_Total,jumlah_Iwak;

    public int getHarga_Total() {
        return harga_Total;
    }

    public void setHarga_Total(int harga_Total) {
        this.harga_Total = harga_Total;
    }

    public String getNama_Iwak() {
        return nama_Iwak;
    }

    public void setNama_Iwak(String nama_Iwak) {
        this.nama_Iwak = nama_Iwak;
    }

    public String getHarga_Iwak() {
        return harga_Iwak;
    }

    public void setHarga_Iwak(String harga_Iwak) {
        this.harga_Iwak = harga_Iwak;
    }

    public String getFoto_Iwak() {
        return Foto_Iwak;
    }

    public void setFoto_Iwak(String foto_Iwak) {
        Foto_Iwak = foto_Iwak;
    }

    public String getHarga_Jual() {
        return harga_Jual;
    }

    public void setHarga_Jual(String harga_Jual) {
        this.harga_Jual = harga_Jual;
    }

    public int getJumlah_Iwak() {
        return jumlah_Iwak;
    }

    public void setJumlah_Iwak(int stok_Iwak) {
        this.jumlah_Iwak = stok_Iwak;
    }

    public Keranjang(){

    }

    public String getId_iwak() {
        return id_iwak;
    }

    public void setId_iwak(String id_iwak) {
        this.id_iwak = id_iwak;
    }
}
