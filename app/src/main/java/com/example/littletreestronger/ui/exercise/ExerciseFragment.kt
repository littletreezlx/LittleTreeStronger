package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.adapter.ExerciseGridViewAdapter
import kotlinx.android.synthetic.main.exercise_fragment.*


class ExerciseFragment : BaseFragment() {

    companion object {
        fun newInstance() = ExerciseFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.exercise_fragment, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titles = arrayOf("Deep Workout", "Run", "Plan", "Record", "Actions")
        val images = intArrayOf(
            R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp
        )
        val onclick = arrayOf(
            ::onClickDeepWorkOut,
            ::onClickRun,
            ::onClickPlan,
            ::onClickRecord,
            ::onClickActions
        )

        val adapter = ExerciseGridViewAdapter(context!!, titles, images)
        gridview.adapter = adapter
        gridview.setOnItemClickListener { parent, view, position, id ->
            onclick[position].invoke()
        }

        adapter.notifyDataSetChanged()


        val a =adapter.getItem(0)
        val b =adapter.getItem(3)
        gridview.invalidate()

    }



    private fun onClickDeepWorkOut(){
        findNavController().navigate(R.id.action_exerciseFragment_to_deepWorkoutFragment)
    }


    private fun onClickRun(){
    //
    }

    private fun onClickPlan(){
        findNavController().navigate(R.id.action_exerciseFragment_to_exercisePlanTableFragment)
    }

    private fun onClickRecord(){
        findNavController().navigate(R.id.action_exerciseFragment_to_exerciseTimeFragment)
    }

    private fun onClickActions(){
        findNavController().navigate(R.id.action_exerciseFragment_to_exerciseActionsFragment)
    }


}
