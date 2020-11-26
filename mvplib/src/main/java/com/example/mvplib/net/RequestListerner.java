package com.example.mvplib.net;


/**
 * 联网回调
 * @author smart
 */
public interface RequestListerner<T> {

    void onSuccess(T result);

    void onError(T result);
}
