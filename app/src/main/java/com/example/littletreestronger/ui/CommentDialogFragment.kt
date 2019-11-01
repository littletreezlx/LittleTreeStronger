package com.example.littletreestronger.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import org.kodein.di.generic.instance
import android.content.DialogInterface
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import com.example.littletreestronger.R
import com.example.littletreestronger.common.base.BaseDialogFragment
import okhttp3.OkHttpClient
import org.jetbrains.anko.support.v4.toast


class CommentDialogFragment: BaseDialogFragment() {


    private val gson: Gson by instance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.diet_fragment_dialog_target, container, false)


        return view

    }


//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
////        return super.onCreateDialog(savedInstanceState)
//        return AlertDialog.Builder(context!!)
//            .setTitle("神灯")
//            .setMessage("来选择你要实现的一个愿望把")
//            .setPositiveButton("车子", DialogInterface.OnClickListener { dialog, which ->
//                toast("车子")
//            })
//            .setNegativeButton("房子", DialogInterface.OnClickListener { dialog, which ->
//                toast("房子")
//            }).create()
//
//    }



}
