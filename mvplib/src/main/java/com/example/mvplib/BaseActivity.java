package com.example.mvplib;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 *
 * @author smart
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected final String BASE_TAG = BaseActivity.class.getSimpleName();

    public BaseGlobalHandler mHandler;
    public ThreadPoolManager mThreadPoolManager;
    protected P basePresenter;
    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mHandler = BaseGlobalHandler.getInstance();
        mHandler.setHandleMsgListener(this);

        mThreadPoolManager = ThreadPoolManager.getInstance();

        basePresenter = createPresenter();
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
        showLoadings("");
    }

    @Override
    public void hideLoading() {
        hideLoadings();
    }

    @Override
    public void showError() {
        showErrors("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁移除所有消息，避免内存泄露
        mHandler.removeCallbacks(null);
        if (null != basePresenter) {
            basePresenter.detachView();
        }
    }

    protected void showLoadings(String loading) {
        Log.d(BASE_TAG, loading + "加载中。。。");
    }

    protected void hideLoadings() {
        Log.d(BASE_TAG, "完成加载");
    }

    protected void showErrors(String error) {
        Log.d(BASE_TAG, error + "错误弹窗xxxxxxxxxxxxxxx");
    }
}
