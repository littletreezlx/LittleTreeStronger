package com.example.littletreestronger.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.littletreestronger.R
import java.util.ArrayList


class ExerciseGridViewAdapter(
    val context: Context,
    titles: Array<String>,
    images: IntArray
) : BaseAdapter() {


    //  private String[] titles = new String[]{"pic1", "pic2", "pic3", "pic4"};
    //  private int[] images = new int[]{R.drawable.ic100, R.drawable.ic100, R.drawable.ic100, R.drawable.ic100};

    private val inflater: LayoutInflater
    private val pictures: ArrayList<Picture>


    init {
        pictures = ArrayList()
        inflater = LayoutInflater.from(context)
        for (i in images.indices) {
            val picture = Picture(titles[i], images[i])
            pictures.add(picture)
        }

    }

    override fun getCount(): Int {
        return pictures.size
    }

    override fun getItem(position: Int): Any {
        return pictures[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder
        val resultConvertView: View

        if (convertView == null) {
            resultConvertView = LayoutInflater.from(parent?.context).inflate(R.layout.exercise_grid_item, parent, false)
            viewHolder = ViewHolder(resultConvertView)
            resultConvertView.tag = viewHolder
        } else {
            resultConvertView = convertView
            viewHolder = resultConvertView.tag as ViewHolder
        }

        prepareViewHolder(viewHolder, position)
        return resultConvertView
    }



    internal inner class ViewHolder(itemView: View) {
        val title: TextView
        var image: ImageView

        init {
            title = itemView.findViewById(R.id.tv_item)
            image = itemView.findViewById(R.id.iv_item)

        }
    }


    private fun prepareViewHolder(viewHolder: ViewHolder, position: Int){
        viewHolder.title.text = pictures[position].title
        Glide.with(context).load(pictures[position].imageId).into(viewHolder.image)
    }

    data class Picture(val title: String, val imageId: Int)


}
