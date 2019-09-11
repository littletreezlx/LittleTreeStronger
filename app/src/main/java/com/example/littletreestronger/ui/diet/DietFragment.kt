package com.example.littletreestronger.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.adapter.DietRecordAdapter
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.viewmodel.DietRecordViewModel
import com.example.littletreestronger.viewmodel.ExerciseRecordViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_diet.*
import kotlinx.android.synthetic.main.fragment_exercise_record.*
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


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
//        btn_discovery_test.setOnClickListener {
//            val directions = DietFragmentDirections.actionDietFragmentToRecommendFoodFragment()
//                .run {
//                setName("alice")
//            }
//            it.findNavController().navigate(directions)
//        }
        initRecyclerView()
    }

    fun initRecyclerView(){
        val adapter = DietRecordAdapter(DietRecord.TYPE_MEAL_BREAKFAST)
        recyclerview_diet_record.adapter = adapter
        viewModel.getDietRecords().observe(this, Observer{
            adapter.submitList(it)
            val i =1
        })
    }

}
