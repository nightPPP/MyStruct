package com.example.mystruct;

import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mvplib.BaseActivity;
import com.example.mystruct.util.ToastUtil;

/**
 * @author smart
 */
public class MainActivity extends BaseActivity {

    private TextView btn;
    private TextView tvMsg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btn =  findViewById(R.id.tv_btn);
        tvMsg =  findViewById(R.id.tv_msg);

    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast("点击");
                mHandler.sendEmptyMessage(0);
            }
        });
    }


    @Override
    public void handleMsg(Message msg) {
        super.handleMsg(msg);
        Log.d("ddddddddddd", "收到消息");
        int what = msg.what;
        if (0 == what){
            tvMsg.setText("dddd");
        }

    }
}