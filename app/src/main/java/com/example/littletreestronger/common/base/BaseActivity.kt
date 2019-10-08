package com.example.littletreestronger.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        BaseApplication.instance().getActivityManage().addActivity(this)



        Timber.d("onCreste")
    }


    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
//        BaseApplication.getApplication()!!.getActivityManage().removeActivityty(this)
    }


}