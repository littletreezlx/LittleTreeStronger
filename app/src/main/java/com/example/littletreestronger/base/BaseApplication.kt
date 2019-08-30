package com.example.littletreestronger.base

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import com.example.littletreestronger.di.httpDiModule
import com.facebook.stetho.Stetho
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber


open class BaseApplication : Application(), KodeinAware{




    override val kodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@BaseApplication }
        import(androidXModule(this@BaseApplication))
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