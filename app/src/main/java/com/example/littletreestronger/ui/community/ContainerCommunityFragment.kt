package com.example.littletreestronger.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R


class ContainerCommunityFragment : BaseFragment() {

    companion object {
        fun newInstance() = ContainerCommunityFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.community_fragment_container, container, false)

        return view
    }





}
