package com.example.mvplib;

public interface BaseView extends BaseGlobalHandler.HandleMsgListener{
    void showLoading();
    void hideLoading();
    void showError();
}
