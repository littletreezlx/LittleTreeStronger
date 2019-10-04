package com.example.littletreestronger.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R


class ContainerDietFragment : BaseFragment() {

    companion object {
        fun newInstance() = ContainerDietFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.diet_fragment_container, container, false)

        return view
    }



}
