package com.example.littletreestronger.common.base

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

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override val kodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@BaseApplication }
        import(androidXModule(this@BaseApplication))
//        import(androidSupportModule(this@BaseApplication))

        import(httpDiModule)
    }

    private var application: BaseApplication? = null



    override fun onCreate() {
        super.onCreate()
        instance = this
        initLogger()
        initStetho()
//
//        if (LeakCanary.isInAnalyzerProcess(this)) {//1
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.
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


    fun isDebug(context: Context): Boolean {
        return context.applicationInfo != null && context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }

}