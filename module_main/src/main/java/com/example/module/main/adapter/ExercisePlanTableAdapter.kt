package com.example.module.main.adapter

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
            convertView = LayoutInflater.from(parent.context).inflate(com.example.module.main.R.layout.item_exercise_plan_table, null)
            viewHolder.title = convertView!!.findViewById(com.example.module.main.R.id.item_tv_plan_name) as TextView
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
