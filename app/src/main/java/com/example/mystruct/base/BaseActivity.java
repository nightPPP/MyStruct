package com.example.mystruct.base;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvplib.BaseView;
import com.example.mystruct.util.ToastUtil;

/**
 * @author liuy
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();

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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return checkBackAction() || super.onKeyDown(keyCode, event);
    }

    long mTimeout;
    boolean mFlag;
    private boolean checkBackAction() {
        long time = 3000L;
        boolean flag = mFlag;
        mFlag = true;

        boolean timeout =  (mTimeout == -1|| (System.currentTimeMillis() - mTimeout) > time);
        if(mFlag && (mFlag != flag || timeout)) {
            mTimeout = System.currentTimeMillis();
            ToastUtil.showToast("再点击一次回到桌面");
            return true;
        }
        return!mFlag;
    }
}
