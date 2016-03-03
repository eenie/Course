package com.eenie.mob.course;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.lecloud.config.LeCloudPlayerConfig;
import com.letv.proxy.LeCloudProxy;

import java.util.List;

/**
 * Created by Eenie on 2016/3/2.
 * Email:472279981@qq.com
 */
public class CourseApplication extends Application {
    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps != null) {
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName;
                }
            }
        }
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String processName = getProcessName(this, android.os.Process.myPid());
        if (getApplicationInfo().packageName.equals(processName)) {
            LeCloudProxy.init(getApplicationContext());
            LeCloudPlayerConfig.getInstance().setDeveloperMode(true).setIsApp();
        }
    }


}
