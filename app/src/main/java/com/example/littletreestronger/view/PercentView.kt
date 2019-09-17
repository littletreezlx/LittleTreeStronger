package com.example.littletreestronger.view


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.graphics.*
import kotlin.math.*
import com.example.littletreestronger.R
import org.jetbrains.anko.attr


class PercentView@JvmOverloads constructor(context: Context, val attrs: AttributeSet? = null, val defStyleAttr: Int = 0): View(context, attrs, defStyleAttr) {

    init {
    }

    val defaultWidth = 100
    val defaultHeight = 100
    val defaultPadding = 5
    val padding = defaultPadding
    val xpadding = arrayOf(defaultPadding, paddingTop, paddingBottom, paddingLeft, paddingRight).max()
    val greyPaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.light_grey)
        strokeWidth = 0f
        style = Paint.Style.FILL
    }
    val whitePaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.white)
        strokeWidth = 0f
        style = Paint.Style.FILL
    }
    val greenPaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.light_green)
        strokeWidth = 0f
        style = Paint.Style.FILL
    }
    val redPaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.light_red)
        strokeWidth = 0f
        style = Paint.Style.FILL
    }
    val greenToYellowPaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.light_green)
        strokeWidth = 0f
        style = Paint.Style.FILL
    }
    val yellowToRedPaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.light_red)
        strokeWidth = 0f
        style = Paint.Style.FILL
    }


    val textPaint = Paint().apply {
        isAntiAlias = true
        color = context.getColor(com.example.littletreestronger.R.color.black)
        textSize = 30f
        textAlign = Paint.Align.CENTER
//        typeface = Typeface.DEFAULT
//        isFakeBoldText = true
    }




//    parseColor("#E91E63")
    //temp int
    var percent = 0
    var yellowRange = 15
    var redRange = 15
    var isFirstDraw = true

    var centerX = 0f
    var centerY = 0f
    var radius = 0f
    var arcWidth = 0f


    // force circle
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var width = MeasureSpec.getSize(widthMeasureSpec)
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST){
            width =  defaultWidth
        }
        var height = MeasureSpec.getSize(heightMeasureSpec)
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST){
            height = defaultHeight
        }
        val radius = Math.min(width, height)
        val measuredWidth =  MeasureSpec.makeMeasureSpec(radius, MeasureSpec.EXACTLY)
        val measuredHeight =  MeasureSpec.makeMeasureSpec(radius, MeasureSpec.EXACTLY)
        setMeasuredDimension(measuredWidth, measuredHeight)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (isFirstDraw){
            centerX = width / 2f
            centerY = height / 2f
            radius = Math.min(width, height) / 2f - padding
            arcWidth = radius / 8
            textPaint.textSize = radius / 3

            val x0 = centerX
            val y0 = 0f + padding
            val x10 = centerX + radius * sin(36f / 180 * PI).toFloat()
            val y10 = centerY - radius * cos(36f / 180 * PI).toFloat()
            val x20 = centerX + radius * sin(72f / 180 * PI).toFloat()
            val y20 = centerY - radius * cos(72f / 180 * PI).toFloat()

            greenToYellowPaint.shader = LinearGradient(x0, y0, x10, y10,
                context.getColor(com.example.littletreestronger.R.color.light_green),
                context.getColor(com.example.littletreestronger.R.color.light_yellow), Shader.TileMode.CLAMP)

            yellowToRedPaint.shader = LinearGradient(x10, y10, x20, y20,
                context.getColor(com.example.littletreestronger.R.color.light_yellow),
                context.getColor(com.example.littletreestronger.R.color.light_red), Shader.TileMode.CLAMP)

            isFirstDraw = false
        }
        canvas?.drawCircle(centerX, centerY, radius, greyPaint)
        //can save

        if (percent > 0){
            val greenRangeAngle = min(percent * 3.6f, 100 * 3.6f)
            canvas?.drawArc(centerY - radius, centerX - radius, centerX + radius, centerY + radius, 270f,  greenRangeAngle ,true, greenPaint)
        }


        if (percent > 100 ){
            val yellowRangeAngle = min((percent - 100) * 3.6f, 10 * 3.6f)
            canvas?.drawArc(centerY - radius, centerX - radius, centerX + radius, centerY + radius, 270f, yellowRangeAngle ,true, greenToYellowPaint)
        }
        if (percent > 110){
            val redRangeAngle = min((percent - 110) * 3.6f, 10 * 3.6f)
            canvas?.drawArc(centerY - radius, centerX - radius, centerX + radius, centerY + radius, 270f + 36f, redRangeAngle ,true, yellowToRedPaint)
        }
        if (percent > 120){
            canvas?.drawCircle(centerX, centerY, radius, redPaint)
        }

        canvas?.drawCircle(centerX, centerY, radius - arcWidth, whitePaint)
        //Text

        val text = percent.toString() + "%"
        //计算baseline
        val fontMetrics = textPaint.fontMetrics
        val distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
        val baseline = centerY + distance
        canvas?.drawText(text, centerX, baseline, textPaint)





        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.PercentView, defStyleAttr,0)
        val title = typedArray.getString(R.styleable.PercentView_title)
        typedArray.recycle()

        title?.let{
            textPaint.textSize = 40f
            canvas?.drawText(title, centerX, baseline + 50, textPaint)

        }
    }


    override fun invalidate() {
//        isFirstDraw = true
        super.invalidate()
    }

    //
//        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.PercentView, defStyleAttr,0)
//        val c = typedArray.getColor(R.styleable.PercentView_bgColor, R.color.light_yellow)
//        typedArray.recycle()
//        whitePaint.color = c
//        canvas?.drawCircle(centerX, centerY, radius - arcWidth, whitePaint)
}