package com.example.common.base

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.di.httpDiModule
import com.facebook.stetho.Stetho
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber


open class BaseApplication : Application(), KodeinAware{




    override val kodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@BaseApplication }
        import(androidModule(this@BaseApplication))
//        import(androidSupportModule(this@BaseApplication))

        import(httpDiModule)
    }

    private var application: BaseApplication? = null

//    private var activityManage: ActivityManager? = null

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        application = this
        //MultiDex分包方法 必须最先初始化
//        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //router
        initARouter()
        //log
        initLogger()
        //database
        initStetho()

    }


    private fun initStetho(){
        if (isDebug(this)) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private  fun initARouter(){
        if (isDebug(this)) {
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }


    private fun initLogger(){
        if (isDebug(this)) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("Timber Start!")
//        else {
//            Timber.plant(new CrashReportingTree());
//        }
    }



    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    fun isDebug(context: Context): Boolean {
        return context.applicationInfo != null && context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }

}