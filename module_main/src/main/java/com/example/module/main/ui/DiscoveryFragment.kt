package com.example.module.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.common.base.BaseFragment
import com.example.module.main.R
import kotlinx.android.synthetic.main.fragment_discovery.*


class DiscoveryFragment : BaseFragment() {

    companion object {
        fun newInstance() = DiscoveryFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_discovery, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_discovery_test.setOnClickListener {
            it.findNavController().navigate(R.id.action_discoveryFragment_to_recommendFoodFragment)
        }
    }




}
