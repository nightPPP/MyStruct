package com.example.mvplib;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView>{

    protected M mModel;

    //由于 V 一般比较大，这里采用了弱引用的写法，避免内存泄漏。
    protected WeakReference<V> mViewRef;
    public void onAttach(M model, V view){
        mModel = model;
        mViewRef =new WeakReference<>(view);
    }
    protected V getView(){
        return isViewAttached() ? mViewRef.get() :null;
    }

    //用于检测 V 是否已关联 P,为真则让getView()返回对应的 V，否则返回 null
    protected boolean isViewAttached(){
        return null!= mViewRef && null!= mViewRef.get();
    }

    public void onDetach(){
        if(null!= mViewRef) {
            mViewRef.clear();
            mViewRef =null;
        }
    }
}