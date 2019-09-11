package com.example.littletreestronger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.littletreestronger.data.model.DietRecord


class DietRecordAdapter
    (private val mealType : Int)
    : PagedListAdapter<DietRecord, DietRecordAdapter.ViewHolder>(diffCallback){


    companion object {
        val TYPE_HEADER = 0
        val TYPE_BODY = 1
        val TYPE_FOOTER = 2

        private val diffCallback = object : DiffUtil.ItemCallback<DietRecord>() {
            override fun areItemsTheSame(oldItem: DietRecord, newItem: DietRecord): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DietRecord, newItem: DietRecord): Boolean =
                oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(LayoutInflater.from(parent.context).inflate(com.example.littletreestronger.R.layout.item_diet_record_header, parent, false))
            TYPE_FOOTER -> FooterViewHolder(LayoutInflater.from(parent.context).inflate(com.example.littletreestronger.R.layout.item_diet_record_footer, parent, false))
            else -> ItemViewHolder(LayoutInflater.from(parent.context).inflate(com.example.littletreestronger.R.layout.item_diet_record_body, parent, false))
        }
//        return DietRecordViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        when (getItemViewType(position)) {
            TYPE_HEADER -> bindHeader(viewHolder, position)
            TYPE_FOOTER -> bindFooter(viewHolder, position)
            else -> bindItem(viewHolder, position)
        }
    }


    private fun getRecordItem(position: Int): DietRecord? {
        return getItem(position - 1)
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            itemCount - 1 -> TYPE_FOOTER
            else -> TYPE_BODY
        }
    }


    abstract inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        abstract fun getType(): Int
    }

    inner class HeaderViewHolder(itemView: View) : ViewHolder(itemView){
        var headerTv: TextView
        init {
            headerTv = itemView.findViewById(com.example.littletreestronger.R.id.tv_header)
        }
    }

    inner class ItemViewHolder(itemView: View) : ViewHolder(itemView){
        var nameTv: TextView
        var weightTv: TextView
        init {
            nameTv = itemView.findViewById(com.example.littletreestronger.R.id.tv_name)
            weightTv = itemView.findViewById(com.example.littletreestronger.R.id.tv_weight)
        }
    }

    inner class FooterViewHolder(itemView: View) : ViewHolder(itemView){
        var addBtn: Button
        init {
            addBtn = itemView.findViewById(com.example.littletreestronger.R.id.btn_add)
        }
    }


    fun bindHeader(viewHolder: ViewHolder, position: Int){
        val holder = viewHolder as HeaderViewHolder
        holder.headerTv.text = when (mealType) {
            DietRecord.TYPE_MEAL_BREAKFAST -> "早餐"
            DietRecord.TYPE_MEAL_LUNCH -> "午餐"
            DietRecord.TYPE_MEAL_DINNER -> "晚餐"
            else -> "加餐"
        }
    }

    fun bindItem(viewHolder: ViewHolder, position: Int){
        val holder = viewHolder as ItemViewHolder
        getItem(position)?.let {
            holder.run {
                nameTv.text = it.name
                weightTv.text = it.weight.toString()
            }
        }
    }

    fun bindFooter(viewHolder: ViewHolder, position: Int){
        val holder = viewHolder as FooterViewHolder
    }
}