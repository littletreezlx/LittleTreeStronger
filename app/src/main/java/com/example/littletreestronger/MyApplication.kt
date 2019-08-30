package com.example.littletreestronger

import com.example.littletreestronger.base.BaseApplication


class MyApplication : BaseApplication(){


    override fun onCreate() {
        super.onCreate()

        instance = this
    }




    companion object {

        var instance: MyApplication?  = null

    }

}