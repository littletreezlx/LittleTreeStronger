package com.example.module.time

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ExerciseRecordUI : AnkoComponent<ViewGroup>{



    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        linearLayout {
            lparams(matchParent, dip(50))
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL

            textView {
                id = R.id.time_recyclerview_item_title_tv
                text = "Sherlock"
                textSize = 16f // <- it is sp, no worries
                textColor = Color.BLACK
            }.lparams{
                width = dip(0)
                height = dip(50)
                weight = 2f
            }

            textView {
                id = R.id.time_recyclerview_item_times_tv
                text = "2009"
                textSize = 14f
            }.lparams{
                width = dip(0)
                height = dip(50)
                weight = 1f
            }
        }
    }
}