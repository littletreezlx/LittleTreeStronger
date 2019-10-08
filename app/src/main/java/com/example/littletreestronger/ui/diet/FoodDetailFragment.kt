package com.example.littletreestronger.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.viewmodel.DietRecordViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.main_activity.*
import org.kodein.di.generic.instance


class FoodDetailFragment : BaseFragment() {

    companion object {
        fun newInstance() = FoodDetailFragment()
    }

    private val viewModel: DietRecordViewModel by instance()

    private val gson: Gson by instance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.diet_fragment_food_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.visibility = View.INVISIBLE

    }


    override fun onDestroy() {
        toolbar.visibility = View.VISIBLE
        super.onDestroy()
    }


}
