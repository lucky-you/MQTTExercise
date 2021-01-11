package com.zhowin.mqttexercise.http;

import com.zhowin.mqttexercise.BuildConfig;

/**
 * author : zho
 * date  ：2021/1/11
 * desc ：
 */
public class MqttApi {

    private static boolean DEBUG = true;

    /**
     * 服务端IP
     */
    public static String getMqtt_Url() {
        if (DEBUG) {
            return "tcp://mqtt.inks:1883";
        }
        return "tcp://192.168.1.123:61613";
    }

    /**
     * 用户名
     */
    public static String getName() {
        if (DEBUG) {
            return "admin";//testuser
        }
        return "admin";
    }

    /**
     * 密码
     */
    public static String getPassword() {
        if (DEBUG) {
            return "shmqttfree";//sha256
        }
        return "password";
    }

    /**
     * 订阅主题
     * app接收这个主题的消息
     */
    public static String getTopicSubscribe() {
        if (DEBUG) {
            return "0000000000000";
        }
        return "111111111111111111";
    }

    /**
     * 发布主题
     * app发布消息的主题
     */
    public static String getTopicPublisher(String topic) {
        if (DEBUG) {
            return "/" + topic;
        }
        return "/" + topic;
    }

    /**
     * 设备ID
     *
     * @return
     */
    public static String getClintId() {
        return "00000000";
    }

    /**
     * 标记是否登录
     **/
    public static volatile boolean isBoolean = false;
}
