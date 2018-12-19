package com.example.module.time.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.base.BaseActivity
import com.example.module.time.R
import com.example.module.time.data.ExerciseRecord
import com.example.module.time.di.exerciseTimeDiModule
import com.example.module.time.viewmodel.ExerciseTimeViewModel
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


@Route(path = "/time/exercise")
class ExerciseTimeActivity: BaseActivity(), KodeinAware{


    private val parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)

        import(exerciseTimeDiModule)
        bind<ExerciseTimeActivity>() with instance(this@ExerciseTimeActivity)

    }


    private val viewModel: ExerciseTimeViewModel by instance()

    private val gson: Gson by instance()



    lateinit var recordAdapter: ExerciseRecordAdapter


//    val viewModel : ExerciseTimeViewModel by lazy {
//        ViewModelProviders.of(this).get(ExerciseTimeViewModel::class.java)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getExerciseRecords().observe(this, Observer<List<ExerciseRecord>>{ exerciseRecords ->
            recordAdapter.notifyDataSetChanged()
        })


        verticalLayout {

            recyclerView {
                id = R.id.time_recyclerview

                layoutManager = LinearLayoutManager(this@ExerciseTimeActivity)

//                recordAdapter = ExerciseRecordAdapter(arrayListOf(ExerciseRecord("a",0), ExerciseRecord("b",1)))

                recordAdapter = ExerciseRecordAdapter(viewModel.getExerciseRecords().value!!)

                adapter = recordAdapter
            }.lparams{
                width = matchParent
                height = dip(300)
            }


            button{
                text = "click this"
                onClick {

                    info { "info" + "ccc" }
                    debug("a")
//                    recordAdapter.updateList()
//                    recordAdapter.notifyDataSetChanged()

//                    viewModel.getExerciseRecords().apply {
//
//                        value = value?.apply {
//                            add(
//                                ExerciseRecord(
//                                    ExerciseActionEnum.YINGLA.chineseName,
//                                    Random.nextInt()
//                                )
//                            )
//                            add(
//                                ExerciseRecord(
//                                    ExerciseActionEnum.SHENDUN.chineseName,
//                                    Random.nextInt()
//                                )
//                            )
//                            add(
//                                ExerciseRecord(
//                                    ExerciseActionEnum.WOTUI.chineseName,
//                                    Random.nextInt()
//                                )
//                            )
//                        }
//                    }
                    viewModel.addExerciseRecords()
                }
            }.lparams{
                width = matchParent
                height = dip(100)
            }
        }

//        val viewModel = ViewModelProviders.of(this).get(ExerciseTimeViewModel::class.java)
    }
}