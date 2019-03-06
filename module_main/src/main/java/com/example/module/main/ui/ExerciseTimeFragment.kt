package com.example.module.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.common.base.BaseFragment
import com.example.module.main.R
import com.example.module.main.data.model.ExerciseRecord
import com.example.module.main.viewmodel.ExerciseTimeViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_exercise_record.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance


//@Route(path = "/time/exercise")
class ExerciseTimeFragment: BaseFragment(), KodeinAware{



    private val viewModel: ExerciseTimeViewModel by instance()

    private val gson: Gson by instance()

//    lateinit var recordAdapter: ExerciseRecordAdapter


    override val kodein: Kodein
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_record, container, false)


        val adapter = ExerciseRecordAdapter()
        recyclerview_exercise_reocrd.adapter = adapter

        viewModel.getExerciseRecords().observe(this, Observer <List<ExerciseRecord>>{ exerciseRecords ->
            adapter.updateList(exerciseRecords)
            adapter.notifyDataSetChanged()
        })

        return view
    }



}