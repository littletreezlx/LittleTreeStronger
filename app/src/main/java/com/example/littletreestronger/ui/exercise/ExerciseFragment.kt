package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R
import kotlinx.android.synthetic.main.exercise_fragment.*


class ExerciseFragment : BaseFragment() {

    companion object {
        fun newInstance() = ExerciseFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.exercise_fragment, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_exercise_record.setOnClickListener {
            it.findNavController().navigate(R.id.action_exerciseFragment_to_exerciseTimeFragment)
        }

        btn_exercise_plan_table.setOnClickListener {
            it.findNavController().navigate(R.id.action_exerciseFragment_to_exercisePlanTableFragment)
        }

        btn_exercise_actions.setOnClickListener {
            it.findNavController().navigate(R.id.action_exerciseFragment_to_exerciseActionsFragment)
        }

    }




}
