package com.example.mystruct;

import com.example.mvplib.BaseView;
import com.example.mystruct.bean.BaseResponse;
import com.example.mystruct.bean.DailyBean;

public interface MainView extends BaseView {
    void onSuccess(BaseResponse<DailyBean> result);
}
