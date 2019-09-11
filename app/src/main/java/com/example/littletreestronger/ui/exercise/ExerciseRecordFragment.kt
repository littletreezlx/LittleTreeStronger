package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.adapter.ExerciseRecordAdapter
import com.example.littletreestronger.viewmodel.ExerciseRecordViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_exercise_record.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


//@Route(path = "/time/exercise")
class ExerciseRecordFragment: BaseFragment(){


    private val viewModel: ExerciseRecordViewModel by instance()

    private val gson: Gson by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_record, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ExerciseRecordAdapter()
        recyclerview_exercise_reocrd.adapter = adapter
//        viewModel.getExerciseRecords().observe(this, Observer <List<ExerciseRecord>>{ exerciseRecords ->
//            adapter.updateList(exerciseRecords)
//            adapter.notifyDataSetChanged()
//        })
        viewModel.getExerciseRecords().observe(this, Observer{
            adapter.submitList(it)
            val i =1
        })

        btn_add_random_records.setOnClickListener {
            viewModel.addExerciseRecords()
        }


    }



}