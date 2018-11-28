package com.example.module.share

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.BaseActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout


@Route(path = "/share/share1")
public class ShareActivity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {


            //            val name = editText()
            button("share!!"){
                onClick {
                    toast("hello,share!")
                }
            }

        }

    }



}