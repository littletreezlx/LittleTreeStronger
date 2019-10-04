package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R


class ExerciseActionsFragment : BaseFragment() {

    companion object {
        fun newInstance() = ExerciseActionsFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.exercise_fragment_actions, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }




}
