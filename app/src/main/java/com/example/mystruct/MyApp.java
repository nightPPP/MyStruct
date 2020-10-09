package com.example.mystruct;

import android.app.Application;
import android.util.Log;

/**
 * 应用入口
 * 是整个应用的入口
 * 用于获取应用全局的上下文
 * 应用一跑起来就立即完成的工作，如：初始化三方库，sdk等等可以写入oncreate里面
 */
public class MyApp extends Application {
    private static String Tag = "MyApp";
    private static MyApp instance;
    public static MyApp getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Tag, "-----应用启动");
        instance = this;
    }
}
