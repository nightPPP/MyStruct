package com.example.mvplib;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author smart
 */
public class BaseGlobalHandler extends Handler {

    private String Tag = BaseGlobalHandler.class.getSimpleName();
    private HandleMsgListener listener;

    public BaseGlobalHandler() {
    }

    public static class HandlerHolder{
        private static final BaseGlobalHandler HANDLER = new BaseGlobalHandler();
    }

    public static BaseGlobalHandler getInstance(){
        return HandlerHolder.HANDLER;
    }
    public interface HandleMsgListener{
        void handleMsg(Message msg);
    }

    public void setHandleMsgListener(HandleMsgListener listener){
        this.listener = listener;
    }

    public HandleMsgListener getHandleMsgListener(){
        return listener;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        if (getHandleMsgListener() != null){
            getHandleMsgListener().handleMsg(msg);
        }else {
            Log.e(Tag,"请传入HandleMsgListener对象");
        }

    }
}
