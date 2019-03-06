package com.example.module.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module.main.R
import com.example.module.main.data.model.ExerciseRecord


class ExerciseRecordAdapter
    (var list: List<ExerciseRecord> = listOf())
    : RecyclerView.Adapter<ExerciseRecordAdapter.ExerciseRecordHolder>(){




    inner class ExerciseRecordHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTv: TextView
        var weightTv: TextView
        var timesTv: TextView


        init {
            titleTv = itemView.findViewById(R.id.tv_exercise_name)
            weightTv = itemView.findViewById(R.id.tv_exercise_weight)
            timesTv = itemView.findViewById(R.id.tv_exercise_times)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseRecordHolder{

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise_record, parent, false)
        return ExerciseRecordHolder(view)

    }


    override fun onBindViewHolder(holder: ExerciseRecordHolder, position: Int){
//        val exerciseRecord = list[position]
//        holder.titleTv.text = exerciseRecord.title
//        holder.timesTv.text = exerciseRecord.times.toString()


//        if (list == null || list.size == 0){
//            return
//        }

        list.let {
            it[position].let {
                with(holder) {
                    titleTv.text = it.title
                    weightTv.text = it.weight.toString()
                    timesTv.text = it.times.toString()
                }
            }
        }



//        list[position].let {
//            with(holder){
//                titleTv.text = it.title
//                timesTv.text = it.times.toString()
//            }
//        }

    }


    override fun getItemCount(): Int {

        return list.size
    }


    fun updateList(updatedList: List<ExerciseRecord>){

        list = updatedList
    }

}