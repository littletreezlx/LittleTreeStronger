package com.example.littletreestronger.ui.diet

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat.canScrollVertically
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.adapter.DietRecordAdapter
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.view.PercentView
import com.example.littletreestronger.viewmodel.DietRecordViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_community.*
import kotlinx.android.synthetic.main.fragment_diet.*
import org.jetbrains.anko.windowManager
import org.kodein.di.generic.instance
import kotlin.random.Random


class DietFragment : BaseFragment() {

    companion object {
        fun newInstance() = DietFragment()
    }

    private val viewModel: DietRecordViewModel by instance()

    private val gson: Gson by instance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_diet, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_recommend_food.setOnClickListener {
            val directions = DietFragmentDirections.actionDietFragmentToRecommendFoodFragment()
                .run {
                setName("alice")
            }
            it.findNavController().navigate(directions)
        }


        initRecyclerView()
        other()

//        Handler().postDelayed()

    }


    fun other(){
        btn_set_target.setOnClickListener {
            listOf<PercentView>(percent_view_calories, percent_view_protein, percent_view_fat, percent_view_carbohydrate).map {
                it.percent = Random.nextInt(50) + 80
                it.invalidate()
            }
        }
        traversalViews()

    }

    fun initRecyclerView(){

        val breakfastAdapter = DietRecordAdapter(DietRecord.TYPE_MEAL_BREAKFAST)
        recyclerview_diet_record_breakfast.adapter = breakfastAdapter
        recyclerview_diet_record_breakfast.layoutManager = object : LinearLayoutManager(context){
            override  fun canScrollVertically() = false
        }
        viewModel.getBreakfastDietRecords().observe(this, Observer{
            breakfastAdapter.submitList(it)
        })
        recyclerview_diet_record_breakfast.setNestedScrollingEnabled(false)
//        recyclerview_diet_record_breakfast.setFocusable(false)


        val lunchAdapter = DietRecordAdapter(DietRecord.TYPE_MEAL_LUNCH)
        recyclerview_diet_record_lunch.adapter = lunchAdapter
        recyclerview_diet_record_lunch.layoutManager = object : LinearLayoutManager(context){
            override  fun canScrollVertically() = false
        }
        viewModel.getLunchfastDietRecords().observe(this, Observer{
            lunchAdapter.submitList(it)
        })



        breakfastAdapter.setOnItemClickListener(object : DietRecordAdapter.OnItemClickListener{
            override fun onHeaderClick(position: Int) {
            }

            override fun onBodyClick(position: Int) {
            }

            override fun onFooterClick(position: Int) {
                viewModel.addDietRecords()
            }
        })


////解决数据加载不完的问题
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setHasFixedSize(true);
////解决数据加载完成后, 没有停留在顶部的问题
//        recyclerView.setFocusable(false);

    }



    fun traversalViews(){

        val handler1 = Handler(Handler.Callback {
            println("1")
            true
        })
        handler1.post {
            println("post")
        }


        val handler2 = Handler(Handler.Callback {
            println("2")
            true
        })
    }

    fun testInSampleSize(){

    }



}
