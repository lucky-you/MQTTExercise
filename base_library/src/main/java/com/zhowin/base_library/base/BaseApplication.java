package com.zhowin.base_library.base;

import android.content.Context;
import android.os.Process;

import androidx.multidex.MultiDexApplication;


import com.zhowin.base_library.utils.SPUtils;

import java.util.Iterator;
import java.util.List;


public class BaseApplication extends MultiDexApplication {
    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        SPUtils.init(this);
    }


    public static BaseApplication getInstance() {
        return application;
    }



    /**
     * 获取当前进程的名称
     */
    protected String getCurProcessName(Context context) {
        int pid = Process.myPid();
        android.app.ActivityManager mActivityManager = (android.app.ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (mActivityManager == null) {
            return "";
        }
        List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcessInfoList = mActivityManager.getRunningAppProcesses();
        if (runningAppProcessInfoList == null) {
            return null;
        } else {
            Iterator processInfoIterator = runningAppProcessInfoList.iterator();
            android.app.ActivityManager.RunningAppProcessInfo appProcess;
            do {
                if (!processInfoIterator.hasNext()) {
                    return null;
                }

                appProcess = (android.app.ActivityManager.RunningAppProcessInfo) processInfoIterator.next();
            } while (appProcess.pid != pid);

            return appProcess.processName;
        }
    }

}
