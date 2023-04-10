package com.wam.iwaksbukucatatanpengepulikan.listener;

import com.wam.iwaksbukucatatanpengepulikan.model.Iwak;

import java.util.List;

public interface IIwakLoadListener {
    void onIwakLoadSuccsess(List<Iwak> iwakModelList);
    void onIwakLoadFailed(String message);
}
