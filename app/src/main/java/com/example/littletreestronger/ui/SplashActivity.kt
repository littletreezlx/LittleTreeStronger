package com.example.littletreestronger.ui

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.littletreestronger.common.base.BaseActivity


class SplashActivity : BaseActivity() {


    val instance by lazy { this }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


    }



}