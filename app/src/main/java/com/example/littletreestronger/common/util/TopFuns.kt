package com.example.littletreestronger.common.util

import android.content.Context
import com.bumptech.glide.Glide
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.xml.datatype.DatatypeConstants.MINUTES
import javax.xml.datatype.DatatypeConstants.HOURS
import android.app.ActivityManager
import android.os.Build
import android.os.PowerManager
import android.text.TextUtils








//毫秒转换具体时间
fun millis2Time(millis: Long): String {
    return String.format(
        "%02d:%02d:%02d",
        TimeUnit.MILLISECONDS.toHours(millis),
        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
            TimeUnit.MICROSECONDS.toHours(
                millis
            )
        ),
        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.HOURS.toSeconds(
            TimeUnit.MICROSECONDS.toHours(
                millis
            )
        ) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
    )
}


//判断服务是否启动
fun isServiceRunning(context: Context?, serviceClass: Class<*>): Boolean {
    if (context == null) {
        return false
    }
    val appContext = context.applicationContext
    val manager = appContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    if (manager != null) {
        val infos = manager.getRunningServices(Integer.MAX_VALUE)
        if (infos != null && !infos.isEmpty()) {
            for (service in infos) {
                // 添加Uid验证, 防止服务重名, 当前服务无法启动
                if (getUid(context) === service.uid) {
                    if (serviceClass.name == service.service.className) {
                        return true
                    }
                }
            }
        }
    }
    return false
}


fun getUid(context: Context?): Int {
    if (context == null) {
        return -1
    }

    val pid = android.os.Process.myPid()
    val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    if (manager != null) {
        val infos = manager.runningAppProcesses
        if (infos != null && !infos.isEmpty()) {
            for (processInfo in infos) {
                if (processInfo.pid == pid) {
                    return processInfo.uid
                }
            }
        }
    }
    return -1
}


//检测屏幕是否开启
//除了此方法, 也可以通过监听系统广播, 判断屏幕的亮灭, 即Intent.ACTION_SCREEN_ON或Intent.ACTION_SCREEN_OFF.
fun isScreenOn(context: Context): Boolean {
    val appContext = context.applicationContext
    val pm = appContext.getSystemService(Context.POWER_SERVICE) as PowerManager

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
        pm.isInteractive
    } else {
        pm.isScreenOn
    }
}


//获取当前进程名称, 用于进程保活.
fun getProcessName(context: Context): String? {
    val pid = android.os.Process.myPid()
    val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val infos = manager.runningAppProcesses
    if (infos != null) {
        for (processInfo in infos) {
            if (processInfo.pid == pid) {
                return processInfo.processName
            }
        }
    }
    return null
}


//判断应用是否存活, 通过唯一包名判断.
fun isAppAlive(packageName: String, context: Context?): Boolean {
    if (context == null || TextUtils.isEmpty(packageName)) {
        return false
    }

    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    if (activityManager != null) {
        val procInfos = activityManager.runningAppProcesses
        if (procInfos != null && !procInfos.isEmpty()) {
            for (i in procInfos.indices) {
                if (procInfos[i].processName == packageName) {
                    return true
                }
            }
        }
    }

    return false
}