package com.example.module.community

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.base.BaseActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout


@Route(path = "/community/")
public class ArticleFragment: BaseActivity(){

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