package com.example.mvplib;

public abstract class BasePresenter<V extends BaseView>{

    public V baseView;

    public BasePresenter(V baseView) {
        this.baseView = baseView;
    }

    public void detachView() {
        baseView = null;
    }


}