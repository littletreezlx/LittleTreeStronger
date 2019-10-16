package com.example.littletreestronger.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*
import android.R.id.checkbox
import android.content.Context
import android.view.View
import android.widget.CheckBox




class TestViewModel(val context: Context) {

//    companion object {
//        private const val PAGE_SIZE = 15
//        private const val ENABLE_PLACEHOLDERS = false
//    }
    var ran = Random()


    fun add(a: Int, b: Int): Int{
        return a+b
    }



    fun verify(){

        val i = 0
//        return
        ran.nextLong()

        verify2()
    }



    fun verify2(){
        val i = 0
    }


    fun inverse(view: View) {
        val cb= CheckBox(context)
        cb.isChecked = !cb.isChecked
    }


}
