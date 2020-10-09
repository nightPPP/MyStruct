package com.example.mystruct.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.mvplib.BaseModel;
import com.example.mvplib.BasePresenter;
import com.example.mystruct.util.ReflectUtil;

/**
 * @author liuy
 * @param <T>
 * @param <M>
 */
public abstract class BaseMvpActivity <T extends BasePresenter,M extends BaseModel> extends BaseActivity {
    protected T mPreseter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreseter = (T) ReflectUtil.getT(this, 0);
        mModel = (M) ReflectUtil.getT(this, 1);
        mPreseter.onAttach(mModel, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    protected abstract void loadData();

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPreseter.onDetach();
    }
}
