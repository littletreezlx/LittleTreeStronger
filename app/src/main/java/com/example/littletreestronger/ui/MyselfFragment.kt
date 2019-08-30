package com.example.littletreestronger.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import kotlinx.android.synthetic.main.fragment_diet.*


class MyselfFragment : BaseFragment() {

    companion object {
        fun newInstance() = MyselfFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_myself, container, false)


        val i =1
        return view
    }



}
