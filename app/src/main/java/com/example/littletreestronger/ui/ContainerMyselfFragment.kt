package com.example.littletreestronger.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R


class ContainerMyselfFragment : BaseFragment() {

    companion object {
        fun newInstance() = ContainerMyselfFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_container_myself, container, false)


        val i =1
        return view
    }





}
