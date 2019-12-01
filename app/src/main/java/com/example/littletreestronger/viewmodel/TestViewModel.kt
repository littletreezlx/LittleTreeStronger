package com.example.littletreestronger.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*




class TestViewModel(val str: String): ViewModel() {

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




//
//    fun inverse(view: View) {
//        val cb= CheckBox(context)
//        cb.isChecked = !cb.isChecked
//    }


}
