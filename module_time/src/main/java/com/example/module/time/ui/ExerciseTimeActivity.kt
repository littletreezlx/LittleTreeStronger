package com.example.module.time.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.BaseActivity
import com.example.module.time.ExerciseRecord
import com.example.module.time.ExerciseTimeViewModel
import com.example.module.time.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import kotlin.random.Random


@Route(path = "/time/exercise")
class ExerciseTimeActivity: BaseActivity(){


    lateinit var recordAdapter: ExerciseRecordAdapter


    val viewModel : ExerciseTimeViewModel by lazy {
        ViewModelProviders.of(this).get(ExerciseTimeViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        verticalLayout {

            recyclerView {
                id = R.id.time_recyclerview

                layoutManager = LinearLayoutManager(this@ExerciseTimeActivity)

                recordAdapter = ExerciseRecordAdapter(arrayListOf(ExerciseRecord("a",0), ExerciseRecord("b",1)))
                adapter = recordAdapter
            }.lparams{
                width = matchParent
                height = dip(300)
            }


            button{
                text = "click this"
                onClick {



                    info { "info" + "ccc" }
//
//
                    debug("a")
//                    recordAdapter.updateList()
//                    recordAdapter.notifyDataSetChanged()


                    val a =viewModel.getExerciseRecords().value

                    viewModel.getExerciseRecords().value?.add(ExerciseRecord("a",Random.nextInt()))
                }
            }.lparams{
                width = matchParent
                height = dip(100)
            }
        }




//        val viewModel = ViewModelProviders.of(this).get(ExerciseTimeViewModel::class.java)

        viewModel.getExerciseRecords().observe(this, Observer<ArrayList<ExerciseRecord>>{ exerciseRecords ->
            recordAdapter.notifyDataSetChanged()
        })

    }
}