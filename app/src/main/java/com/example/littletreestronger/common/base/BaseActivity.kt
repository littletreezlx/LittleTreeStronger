package com.example.littletreestronger.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


open class BaseActivity : AppCompatActivity(){


    val TAG by lazy {
        this.javaClass.name + "___LifeCycle___"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("$TAG onCreste")
    }


    override fun onStart() {
        super.onStart()
        Timber.d("$TAG onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("$TAG onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("$TAG onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("$TAG onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("$TAG onDestroy")
    }


}