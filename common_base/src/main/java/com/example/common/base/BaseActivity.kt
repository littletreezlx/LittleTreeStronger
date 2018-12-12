package com.example.common.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger


open class BaseActivity : AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        BaseApplication.instance().getActivityManage().addActivity(this)
    }



    override fun onDestroy() {
        super.onDestroy()
//        BaseApplication.getApplication()!!.getActivityManage().removeActivityty(this)
    }

}