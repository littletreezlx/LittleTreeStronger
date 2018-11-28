package com.example.common

import android.app.ActivityManager
import android.app.Application
import android.content.Context


open class BaseApplication : Application(){

    private var application: BaseApplication? = null

    private var activityManage: ActivityManager? = null

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        application = this
        //MultiDex分包方法 必须最先初始化
//        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
//        activityManage = ActivityManager()

//        initARouter()
//        initLogger()
    }




    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }


}