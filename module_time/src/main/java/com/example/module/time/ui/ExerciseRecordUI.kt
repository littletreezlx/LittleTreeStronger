package com.example.module.time.ui

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.module.time.R
import org.jetbrains.anko.*

class ExerciseRecordUI : AnkoComponent<ViewGroup>{



    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        linearLayout {
            lparams(matchParent, dip(50))
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL

            //name
            textView {
                id = R.id.time_recyclerview_item_title_tv
                textSize = 16f // <- it is sp, no worries
                textColor = Color.BLACK
            }.lparams{
                width = dip(0)
                height = dip(50)
                weight = 2f
            }

            //weight
            textView {
                id = R.id.time_recyclerview_item_weight_tv
                textSize = 14f
            }.lparams{
                width = dip(0)
                height = dip(50)
                weight = 1f
            }

            //times
            textView {
                id = R.id.time_recyclerview_item_times_tv
                textSize = 14f
            }.lparams{
                width = dip(0)
                height = dip(50)
                weight = 1f
            }
        }
    }
}