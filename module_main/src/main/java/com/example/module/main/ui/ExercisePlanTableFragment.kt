package com.example.module.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.module.main.R
import com.example.module.main.adapter.ExercisePlanTableAdapter
import com.example.module.main.viewmodel.ExercisePlanViewModel
import kotlinx.android.synthetic.main.fragment_exercise_plan_table.*


class ExercisePlanTableFragment : Fragment() {


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
