package com.example.littletreestronger

import com.example.littletreestronger.base.BaseApplication
import com.example.littletreestronger.ui.MainActivity


class MyApplication : BaseApplication(){


    override fun onCreate() {
        super.onCreate()
        instance = this
    }




    companion object {
        var instance: MyApplication?  = null
    }


//    lateinit var mainActivity: MainActivity
//
//    fun setMainActivity(mainActivity: MainActivity) {
//        this.mainActivity = mainActivity
//    }
//
//     fun getMainActivity() : MainActivity {
//         return mainActivity
//    }




}