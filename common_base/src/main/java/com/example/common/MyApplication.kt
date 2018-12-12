package com.example.common

import com.example.common.base.BaseApplication


class MyApplication : BaseApplication(){


    override fun onCreate() {
        super.onCreate()

        instance = this
    }




    companion object {

        var instance:MyApplication?  = null

    }

}