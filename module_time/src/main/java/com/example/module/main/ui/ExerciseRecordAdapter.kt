package com.example.module.main.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module.time.R
import com.example.module.main.data.model.ExerciseRecord
import org.jetbrains.anko.AnkoContext


class ExerciseRecordAdapter
    (var list: List<ExerciseRecord> = listOf())
    : RecyclerView.Adapter<ExerciseRecordAdapter.ExerciseRecordHolder>(){




    inner class ExerciseRecordHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTv: TextView
        var weightTv: TextView
        var timesTv: TextView


        init {
            titleTv = itemView.findViewById(R.id.time_recyclerview_item_title_tv)
            weightTv = itemView.findViewById(R.id.time_recyclerview_item_weight_tv)
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