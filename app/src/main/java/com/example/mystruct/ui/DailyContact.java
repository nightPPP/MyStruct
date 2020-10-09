package com.example.mystruct.ui;

import com.example.mvplib.BaseModel;
import com.example.mvplib.BasePresenter;
import com.example.mvplib.BaseView;
import com.example.mystruct.base.MvpListener;

import java.util.List;

public interface DailyContact {

    interface DailyModel extends BaseModel{
        void loadDaily(String url, MvpListener listener);
    }
    interface DailyView extends BaseView {
        void setData(List beanList);
    }
    abstract class DailyPresenter extends BasePresenter{
        protected abstract void loadData(String url);
    }
}
