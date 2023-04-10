package com.wam.iwaksbukucatatanpengepulikan.model;

public class Iwak {
    private String nama_Iwak;
    private String harga_Iwak;
    private String foto_Iwak;

    private String harga_Jual;

    private String stock;

    public Iwak() {
        this.nama_Iwak = nama_Iwak;
        this.harga_Iwak = harga_Iwak;
        this.foto_Iwak = foto_Iwak;
        this.harga_Jual = harga_Jual;
        this.stock = stock;
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
        return foto_Iwak;
    }

    public void setFoto_Iwak(String foto_Iwak) {
        this.foto_Iwak = foto_Iwak;
    }

    public String getHarga_Jual() {return harga_Jual;}

    public void setHarga_Jual(String harga_Jual) {this.harga_Jual = harga_Jual;}

    public String getStock() {return stock;}

    public void setStock(String stock) {this.stock = stock;}

    @Override
    public String toString() {
        return "Iwak{" +
                "nama_Iwak='" + nama_Iwak + '\'' +
                ", harga_Iwak='" + harga_Iwak + '\'' +
                ", foto_Iwak=" + foto_Iwak + '\'' +
                ", harga_Jual='" + harga_Jual + '\'' +
                ", stock='" + stock +
                '}';
    }
}
