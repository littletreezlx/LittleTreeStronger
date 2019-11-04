package com.example.littletreestronger.ui.diet

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.littletreestronger.R
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.adapter.DietRecordAdapter
import com.example.littletreestronger.common.AopOnclick
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.model.TYPE_MEAL_BREAKFAST
import com.example.littletreestronger.data.model.TYPE_MEAL_DINNER
import com.example.littletreestronger.data.model.TYPE_MEAL_LUNCH
import com.example.littletreestronger.view.PercentView
import com.example.littletreestronger.viewmodel.DietRecordViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.diet_fragment.*
import org.kodein.di.generic.instance
import timber.log.Timber
import kotlin.random.Random
import com.example.littletreestronger.ui.CommentDialogFragment
import com.example.littletreestronger.viewmodel.DietRecordViewModelFactory


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
        val view =  inflater.inflate(R.layout.diet_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        other()
        updatePercentView()
    }


    fun other(){

        btn_set_target.setOnClickListener@AopOnclick(1000)
        {
            listOf<PercentView>(percent_view_calories, percent_view_protein, percent_view_fat, percent_view_carbohydrate).map {
                it.percent = Random.nextInt(50) + 80
                it.invalidate()
            }

//            val s = CommentDialogFragment()
//            s.show(parentFragmentManager, "dialog")

//            findNavController().navigate(R.id.action_dietFragment_to_commentDialogFragment)
        }




    }


    private fun initRecyclerView(){
        initAdapter(recyclerview_diet_record_breakfast, TYPE_MEAL_BREAKFAST)
        initAdapter(recyclerview_diet_record_lunch, TYPE_MEAL_LUNCH)
        initAdapter(recyclerview_diet_record_dinner, TYPE_MEAL_DINNER)
    }


    private fun initAdapter(view: RecyclerView,mealType: Int){
        val adapter = DietRecordAdapter(mealType)
        view.adapter = adapter
        view.layoutManager = object : LinearLayoutManager(context){
            override  fun canScrollVertically() = false
        }
        ////解决数据加载不完的问题
        view.setNestedScrollingEnabled(false)
//        view.setHasFixedSize(true)
        ////解决数据加载完成后, 没有停留在顶部的问题
        view.setFocusable(false)

        viewModel.getDietRecords(mealType).observe(this, Observer{
            adapter.submitList(it)
        })
        adapter.setOnItemClickListener(object : DietRecordAdapter.OnItemClickListener{
            override fun onHeaderClick(position: Int) {
            }

            override fun onBodyClick(position: Int) {
            }

            override fun onFooterClick(position: Int) {
                viewModel.addDietRecords(DietRecord.mockDietRecord(mealType))
            }
        })
    }


    private fun updatePercentView(){
        viewModel.calorySum.observe(this, Observer{
            percent_view_calories.percent = it  * 100 / 2000
            percent_view_calories.invalidate()
        })
        viewModel.proteinSum.observe(this, Observer{
            percent_view_protein.percent = it  * 100 / 2000
            percent_view_protein.invalidate()
        })
        viewModel.fatSum.observe(this, Observer{
            percent_view_fat.percent = it  * 100 / 2000
            percent_view_fat.invalidate()
        })
        viewModel.carbohydrateSum.observe(this, Observer{
            percent_view_carbohydrate.percent = it  * 100 / 2000
            percent_view_carbohydrate.invalidate()
        })
    }




}
