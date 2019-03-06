package com.example.module.main.uia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout


class GalleryFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return UI {
            verticalLayout {
                val name2 = editText()
                button("gallery, to share") {
                    onClick { ctx.toast("hello, ${name2.text}!") }
                }
            }
        }.view
    }


    companion object {
        fun newInstance() : GalleryFragment {
            return GalleryFragment();
        }
    }
}