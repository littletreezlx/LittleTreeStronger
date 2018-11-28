package com.example.module.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.module.main.R
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout


class RecordFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return UI {
            verticalLayout {

                //                id = R.id.settingfragment_id

                val name2 = editText()
                button("record, to share") {
                    onClick {
                        ctx.toast("hello, ${name2.text}!")
                        Navigation.findNavController(it!!).navigate(R.id.shareFragment)
                    }
                }
            }
        }.view
    }


    companion object {
        fun newInstance() : RecordFragment {
            return RecordFragment();
        }
    }
}