package com.example.mystruct.ui;

import com.example.mystruct.base.MvpListener;

import java.util.ArrayList;
import java.util.List;

public class DailyPresenterImpl extends DailyContact.DailyPresenter {
    @Override
    protected void loadData(String url) {
        final DailyContact.DailyView mView = (DailyContact.DailyView) getView();
        final DailyContact.DailyModel mModel = (DailyContact.DailyModel) getView();
        if (mView == null){
            return;
        }
        mView.showLoading();
        mModel.loadDaily(url, new MvpListener<Object> () {
            @Override
            public void onSuccess(Object result) {
                mView.hideLoading();
                mView.setData((List) result);
            }

            @Override
            public void onError(String errorMsg) {
                mView.hideLoading();
                mView.showError();
            }
        });

    }
}
