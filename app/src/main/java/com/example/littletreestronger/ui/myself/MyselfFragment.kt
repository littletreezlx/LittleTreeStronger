package com.example.littletreestronger.ui.myself

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.littletreestronger.R
import com.example.littletreestronger.common.base.BaseFragment
import kotlinx.android.synthetic.main.myself_fragment.*
import timber.log.Timber



class MyselfFragment : BaseFragment() {

    companion object {
        fun newInstance() = MyselfFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.myself_fragment, container, false)


        val i =1
        return view
    }


    val myselfViewModel by viewModels<MyselfViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        myselfViewModel.myName.observe(this, Observer{
            Timber.d(Thread.currentThread().name)
            tv_myself_test.text = it
        })

        btn_myself.setOnClickListener {
            myselfViewModel.updateName()
        }

        btn_myself0.setOnClickListener {
//            toast("no block")
        }

//        tv_myself_test.requestLayout()
    }

}
