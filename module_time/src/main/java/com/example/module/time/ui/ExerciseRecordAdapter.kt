package com.example.module.time.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module.time.data.ExerciseRecord
import com.example.module.time.ExerciseRecordUI
import com.example.module.time.R
import org.jetbrains.anko.AnkoContext


class ExerciseRecordAdapter(val list: ArrayList<ExerciseRecord> = arrayListOf()) : RecyclerView.Adapter<ExerciseRecordAdapter.ExerciseRecordHolder>(){


    inner class ExerciseRecordHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTv: TextView
        var timesTv: TextView

        init {
            titleTv = itemView.findViewById(R.id.time_recyclerview_item_title_tv)
            timesTv = itemView.findViewById(R.id.time_recyclerview_item_times_tv)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseRecordHolder{
        return ExerciseRecordHolder(ExerciseRecordUI().createView(AnkoContext.create(parent.context, parent)))
    }


    override fun onBindViewHolder(holder: ExerciseRecordHolder, position: Int){
//        val exerciseRecord = list[position]
//        holder.titleTv.text = exerciseRecord.title
//        holder.timesTv.text = exerciseRecord.times.toString()

        list[position].let {
            with(holder){
                titleTv.text = it.title
                timesTv.text = it.times.toString()
            }
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(){

        this.list.add(ExerciseRecord("c", 10));

    }

}