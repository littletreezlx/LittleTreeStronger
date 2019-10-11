package com.example.littletreestronger.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.littletreestronger.common.base.BaseFragment
import android.widget.Spinner
import com.example.littletreestronger.R
import kotlinx.android.synthetic.main.exercise_fragment_deep_workout.*
import android.widget.AdapterView
import android.R
import com.facebook.stetho.common.LogUtil
import android.R




class DeepWorkoutFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(com.example.littletreestronger.R.layout.exercise_fragment_deep_workout, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinner(spinner_timer)
        initSpinner(spinner_tone)

    }

    
    private fun initSpinner(spinner: Spinner){
        spinner.setDropDownWidth(400) //下拉宽度
        spinner.setDropDownHorizontalOffset(100) //下拉的横向偏移
        spinner.setDropDownVerticalOffset(100) //下拉的纵向偏移
        //spinner.setBackgroundColor(AppUtil.getColor(instance,R.color.wx_bg_gray)); //下拉的背景色
        //spinner mode ： dropdown or dialog , just edit in layout xml
        //spinner.setPrompt("Spinner Title"); //弹出框标题，在dialog下有效
        val spinnerItems = arrayOf("10", "200", "400")
        //自定义选择填充后的字体样式
        val spinnerAdapter = ArrayAdapter(context, com.example.littletreestronger.R.layout.item_select, spinnerItems)
        //自定义下拉的字体样式
        spinnerAdapter.setDropDownViewResource(com.example.littletreestronger.R.layout.item_drop)
        spinner.setAdapter(spinnerAdapter)

        spinner.setOnItemSelectedListener(object:AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent:AdapterView<*>, view:View, pos:Int, id:Long) {

                LogUtil.i(
                    "onItemSelected : parent.id=" + parent.id +
                            ",isSpinnerId=" + (parent.id == com.example.littletreestronger.R.id.spinner_1) +
                            ",viewid=" + view.id + ",pos=" + pos + ",id=" + id
                )


            }
            override fun onNothingSelected(parent:AdapterView<*>) {
            }
        })
    }


}
