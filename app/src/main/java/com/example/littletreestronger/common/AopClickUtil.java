package com.example.littletreestronger.common;

import android.os.SystemClock;
import android.view.View;

import java.util.Timer;

import timber.log.Timber;

public class AopClickUtil {
    /**
     * 最近一次点击的时间
     */
    private static long mLastClickTime;
    /**
     * 最近一次点击的控件ID
     */
    private static int mLastClickViewId;


    private static String s ="1";


    public static boolean isFastDoubleClick(View v, long intervalMillis) {

        Timber.d("点击间隔: %s", intervalMillis);
        Timber.d(AopOnclick.class.getPackage().getName());
        int viewId = v.getId();
//        long time = System.currentTimeMillis();
        long time = SystemClock.elapsedRealtime();
        long timeInterval = Math.abs(time - mLastClickTime);
        if (timeInterval < intervalMillis && viewId == mLastClickViewId) {
            return true;
        } else {
            mLastClickTime = time;
            mLastClickViewId = viewId;
            return false;
        }
    }

}
