package com.example.module.main.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.example.common.BaseActivity
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class SplashActivity : BaseActivity() {


    val instance by lazy { this }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        verticalLayout {

            textView {
                text = "A"
                textSize = 50f
            }.lparams{
                width = matchParent
                height = matchParent

                gravity = Gravity.CENTER
            }

        }


        Handler().postDelayed({
            startActivity(Intent(instance, MainActivity::class.java))
            instance.finish()
        }, 1000)

    }



}