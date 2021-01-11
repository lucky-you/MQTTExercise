package com.zhowin.mqttexercise.callback;

/**
 * author : zho
 * date  ：2021/1/11
 * desc ：
 */
public interface MessageHandlerCallBack {


    void messageSuccess(String topicName, String messagePayload);
}
