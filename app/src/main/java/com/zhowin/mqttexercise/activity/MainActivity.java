package com.zhowin.mqttexercise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.zhowin.mqttexercise.R;
import com.zhowin.mqttexercise.base.BaseBindActivity;
import com.zhowin.mqttexercise.callback.MessageHandlerCallBack;
import com.zhowin.mqttexercise.databinding.ActivityMainBinding;
import com.zhowin.mqttexercise.manager.MQTTManager;

public class MainActivity extends BaseBindActivity<ActivityMainBinding> {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        MQTTConnent();
    }

    private void MQTTConnent() {
        MQTTManager instance = MQTTManager.getInstance(mContext);
        instance.setMessageHandlerCallBack(new MessageHandlerCallBack() {
            @Override
            public void messageSuccess(String topicName, String s) {
                Log.e("xy", "messageSuccess: " + s);
                mBinding.tvText.setText("链接成功");
            }
        });
        instance.connect();
    }
}
