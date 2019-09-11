package com.example.littletreestronger.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein


open class BaseFragment : Fragment(), KodeinAware {


    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        BaseApplication.instance().getActivityManage().addActivity(this)
    }



    override fun onDestroy() {
        super.onDestroy()
//        BaseApplication.getApplication()!!.getActivityManage().removeActivityty(this)
    }


    fun navigateUp(){
        findNavController().navigateUp()
    }

}