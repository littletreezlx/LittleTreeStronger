package com.example.littletreestronger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView




class ExercisePlanTableAdapter
    (var list: List<String> = listOf())
    : BaseAdapter(){

    internal inner class ViewHolder {
        var title: TextView? = null
        var image: ImageView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView = LayoutInflater.from(parent.context).inflate(com.example.littletreestronger.R.layout.exercise_recycle_item_plan, null)
            viewHolder.title = convertView!!.findViewById(com.example.littletreestronger.R.id.item_tv_plan_name) as TextView
            convertView.tag = viewHolder

            viewHolder.title!!.setText(list.get(position))

        } else {
            viewHolder = convertView.tag as ViewHolder
        }

//        viewHolder.title!!.setText(list.get(position))

        return convertView
    }


    override fun getCount(): Int {
        return list.size
    }


    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }



    fun updateList(updatedList: List<String>){

        list = updatedList
    }

}
