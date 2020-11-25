package com.example.mvplib;

import android.os.Bundle;
import android.os.Message;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseView, BaseGlobalHandler.HandleMsgListener{

    public BaseGlobalHandler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mHandler = BaseGlobalHandler.getInstance();
        mHandler.setHandleMsgListener(this);

        initView();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Override
    public void handleMsg(Message msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
