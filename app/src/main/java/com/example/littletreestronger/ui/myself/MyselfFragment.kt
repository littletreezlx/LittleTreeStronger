package com.example.littletreestronger.ui.myself

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R


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



}
