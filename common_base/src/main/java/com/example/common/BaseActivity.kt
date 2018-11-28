package com.example.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        BaseApplication.instance().getActivityManage().addActivity(this)
    }



    override fun onDestroy() {
        super.onDestroy()
//        BaseApplication.getApplication()!!.getActivityManage().removeActivityty(this)
    }

}