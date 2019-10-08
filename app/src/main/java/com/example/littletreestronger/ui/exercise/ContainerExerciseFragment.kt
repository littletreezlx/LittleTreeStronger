package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R


class ContainerExerciseFragment : BaseFragment() {

    companion object {
        fun newInstance() = ContainerExerciseFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.exercise_fragment_container, container, false)

        return view
    }





}
