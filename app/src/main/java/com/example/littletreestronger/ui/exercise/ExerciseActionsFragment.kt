package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import kotlinx.android.synthetic.main.fragment_exercise.*


class ExerciseActionsFragment : BaseFragment() {

    companion object {
        fun newInstance() = ExerciseActionsFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_exercise_actions, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }




}
