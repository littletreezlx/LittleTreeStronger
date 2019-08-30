package com.example.littletreestronger.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.adapter.ExercisePlanTableAdapter
import com.example.littletreestronger.viewmodel.ExercisePlanViewModel
import kotlinx.android.synthetic.main.fragment_exercise_plan_table.*


class ExercisePlanTableFragment : BaseFragment() {


    private val viewModel = ExercisePlanViewModel()
    private val adapter = ExercisePlanTableAdapter()

    companion object {
        fun newInstance() = ExercisePlanTableFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_exercise_plan_table, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        gridview.adapter = adapter
//        btn_exercise_record.setOnClickListener {
//            it.findNavController().navigate(R.id.action_mainFragment_to_exerciseTimeFragment)
//        }

        viewModel.getExercisePlanNameList().observe(
            this, Observer {
                adapter.updateList(it)
            }
        )


    }







}
