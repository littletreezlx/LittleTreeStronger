package com.example.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


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