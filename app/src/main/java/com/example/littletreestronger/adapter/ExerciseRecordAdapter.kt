package com.example.littletreestronger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.littletreestronger.R
import com.example.littletreestronger.data.model.ExerciseRecord


class ExerciseRecordAdapter : PagedListAdapter<ExerciseRecord, ExerciseRecordAdapter.ExerciseRecordViewHolder>(diffCallback){


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ExerciseRecord>() {
            override fun areItemsTheSame(oldItem: ExerciseRecord, newItem: ExerciseRecord): Boolean =
                oldItem.exerciseRecordId == newItem.exerciseRecordId

            override fun areContentsTheSame(oldItem: ExerciseRecord, newItem: ExerciseRecord): Boolean =
                oldItem == newItem
        }
    }


    inner class ExerciseRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTv: TextView
        var weightTv: TextView
        var timesTv: TextView

        init {
            titleTv = itemView.findViewById(R.id.tv_exercise_name)
            weightTv = itemView.findViewById(R.id.tv_exercise_weight)
            timesTv = itemView.findViewById(R.id.tv_exercise_times)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseRecordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise_record, parent, false)
        return ExerciseRecordViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ExerciseRecordViewHolder, position: Int){
        getItem(position)?.let {
            viewHolder.run {
                titleTv.text = it.title
                weightTv.text = it.weight.toString()
                timesTv.text = it.times.toString()
            }
        }
//        list.let {
//            it[position].let {
//                with(viewHolder) {
//                    titleTv.text = it.title
//                    weightTv.text = it.weight.toString()
//                    timesTv.text = it.times.toString()
//                }
//            }
//        }

    }
}