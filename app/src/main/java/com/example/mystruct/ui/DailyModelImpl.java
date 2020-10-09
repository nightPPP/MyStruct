package com.example.mystruct.ui;

import com.example.mystruct.base.MvpListener;
import com.example.mystruct.bean.DailyBean;
import com.example.mvplib.net.MyListerner;
import com.example.mvplib.net.RequestManager;

public class DailyModelImpl implements DailyContact.DailyModel {
    @Override
    public void loadDaily(String url, final MvpListener listener) {
        RequestManager.getInstance().sendGet(url, DailyBean.class, new MyListerner() {
            @Override
            public void onSuccess(Object result) {
                listener.onSuccess(((DailyBean) result).getStories());
            }

            @Override
            public void onError(String errorMsg) {
                listener.onError(errorMsg);
            }
        });
    }
}
