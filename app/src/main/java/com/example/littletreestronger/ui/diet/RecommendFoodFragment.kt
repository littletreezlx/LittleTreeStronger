package com.example.littletreestronger.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import kotlinx.android.synthetic.main.fragment_diet_recommend.*


class RecommendFoodFragment : BaseFragment() {

    companion object {
        fun newInstance() = RecommendFoodFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_diet_recommend, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        tv_rec.setText(
//            RecommendFoodFragmentArgs.fromBundle(
//                arguments!!
//            ).name)

        btn_apple.setOnClickListener {
            findNavController().navigate(R.id.action_recommendFoodFragment_to_foodDetailFragment)
        }



//        fragmentManager.beginTransaction().add()
//        fragmentManager.beginTransaction().replace()


    }





}
