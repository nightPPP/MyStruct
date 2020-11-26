package com.example.mystruct;

import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.mvplib.BaseActivity;
import com.example.mystruct.bean.BaseResponse;
import com.example.mystruct.bean.DailyBean;
import com.example.mystruct.util.ToastUtil;

/**
 * @author smart
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView{

    private TextView btn;
    private TextView tvMsg;
    private TestRunnable testRunnable;

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
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast("点击");
                testRunnable = new TestRunnable();
                showLoading();
                mThreadPoolManager.execute(testRunnable);
            }
        });
    }

    @Override
    public void onSuccess(BaseResponse<DailyBean> result) {
        hideLoading();
        mHandler.sendEmptyMessage(0);
    }

    class TestRunnable implements Runnable{
        @Override
        public void run() {
            basePresenter.addNet();
        }
    }

    private int index = 0;
    @Override
    public void handleMsg(Message msg) {
        super.handleMsg(msg);
        hideLoading();
        int what = msg.what;
        if (0 == what){
            tvMsg.setText(String.valueOf(index++));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != testRunnable){
            mThreadPoolManager.remove(testRunnable);
        }
    }
}