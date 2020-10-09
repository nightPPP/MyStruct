package com.example.mystruct.base;


/**
 * @author liuy
 */
public interface MvpListener<T extends Object> {
    /**
     *
     * @param result
     */
     void onSuccess(T result);

    /**
     *
     * @param errorMsg
     */
    void onError(String errorMsg);
}
