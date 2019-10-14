package com.example.littletreestronger

import android.content.Context
import androidx.multidex.MultiDex
import com.example.littletreestronger.common.base.BaseApplication


class MyApplication : BaseApplication(){


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: MyApplication?  = null
    }


}