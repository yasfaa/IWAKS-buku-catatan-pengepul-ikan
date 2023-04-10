package com.wam.iwaksbukucatatanpengepulikan.listener;

import com.wam.iwaksbukucatatanpengepulikan.model.Keranjang;

import java.util.List;

public interface IKeranjangLoadListener {
    void onKeranjangLoadSuccsess(List<Keranjang> iwakModelList);
    void onKeranjangLoadFailed(String message);
}
