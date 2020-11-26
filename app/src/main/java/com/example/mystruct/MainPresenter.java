package com.example.mystruct;

import com.example.mvplib.BasePresenter;
import com.example.mvplib.net.RequestListerner;
import com.example.mvplib.net.RequestManager;
import com.example.mystruct.bean.BaseResponse;
import com.example.mystruct.bean.DailyBean;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView baseView) {
        super(baseView);
    }

    protected void addNet(){
        BaseResponse<DailyBean> response = new BaseResponse<>();
        baseView.onSuccess(response);

//        RequestManager.getInstance().sendGet("", BaseResponse.class, new RequestListerner<BaseResponse<DailyBean>>() {
//
//            @Override
//            public void onSuccess(BaseResponse<DailyBean> result) {
//                baseView.onSuccess(result);
//            }
//
//            @Override
//            public void onError(BaseResponse<DailyBean> result) {
//
//            }
//        });
    }
}
