package com.example.mvplib.net;


/**
 * @author smart
 */
public interface MyListerner<T> {

    void onSuccess(T result);

    void onError(String errorMsg);
}
