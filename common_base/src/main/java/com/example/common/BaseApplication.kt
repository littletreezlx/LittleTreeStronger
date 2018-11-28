package com.example.common

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import android.content.pm.ApplicationInfo




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

        initARouter()
//        initLogger()
    }

     fun initARouter(){
        if (isDebug(this)) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }




    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    fun isDebug(context: Context): Boolean {
        return context.applicationInfo != null && context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }

}