package com.example.littletreestronger.common.base

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.jetbrains.anko.displayMetrics
import android.view.WindowManager
import kotlin.math.min
import kotlin.math.round


//UI

fun Context.getCompressedBitmap(resId: Int, reqHeight: Int, reqWidth: Int):  Bitmap {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(resources, resId, options)

    options.inSampleSize = calculateInSampleSize(options, reqHeight, reqWidth)
    options.inJustDecodeBounds
    return  BitmapFactory.decodeResource(resources, resId, options)
}

fun calculateInSampleSize(options: BitmapFactory.Options, reqHeight: Int, reqWidth: Int): Int{
    val height = options.outHeight
    val width = options.outWidth
    var inSampleSize = 1
    if (height > reqHeight || width > reqWidth) {
        val heightRatio = round(height.toFloat() / reqHeight.toFloat())
        val widthRatio = round(width.toFloat() / reqWidth.toFloat())
        inSampleSize = min(heightRatio, widthRatio).toInt()

        //计算原始图片总像素
        val totalPixels = width * height
        //所需总像素*2,长和宽的根号2倍
        val totalReqPixelsCap = reqWidth * reqHeight * 2
        //如果遇到很长，或者是很宽的图片时，这个算法比较有用 
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap)
            inSampleSize++
    }
    return inSampleSize
}


fun Context.getScreenWidthPx(): Int {
    return displayMetrics.widthPixels
}

fun Context.getScreenHeightPx(): Int {
    return displayMetrics.widthPixels
}

fun Context.getScreenWidthDp(): Int {
    return (displayMetrics.widthPixels / displayMetrics.density).toInt()
}

fun Context.getScreenHeightDp(): Int {
    return (displayMetrics.heightPixels / displayMetrics.density).toInt()
}

fun Context.getStateBarHeightPx(): Int {
    var result = 60
    val resourceId = this.getResources().getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = this.getResources().getDimensionPixelSize(resourceId)
    }
    return result
}


//获取NavigationBar的高度
fun Context.getNavigationBarHeight(): Int {
    val hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey()
    val hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK)
    if (!hasMenuKey && !hasBackKey) {
        val resources = getResources()
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    } else {
        return 0
    }
}


fun AppCompatActivity.setStatusBarFullTransparent() {
    if (Build.VERSION.SDK_INT >= 21) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.getDecorView()
            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(Color.TRANSPARENT)
    } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //虚拟键盘也透明
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }
}


//沉浸状态栏
fun AppCompatActivity.steepStatusBar(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // 透明状态栏
        window.addFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        // 透明导航栏
        getWindow().addFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }
}


fun AppCompatActivity.setStatusBarColor(color : Int){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        // 透明状态栏
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        //设置状态栏颜色
//        window.setStatusBarColor(color)

    }
}


fun AppCompatActivity.hideBottomUIMenu() {
    //隐藏虚拟按键，并且全屏
    if (Build.VERSION.SDK_INT < 19) { // lower api
        val v = this.getWindow().getDecorView()
        v.setSystemUiVisibility(View.GONE)
    } else if (Build.VERSION.SDK_INT >= 19) {
        //for new api versions.
        val decorView = getWindow().getDecorView()
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        //                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions)
    }
}


fun Int.toDp(context: Context): Int{
    return (this / context.displayMetrics.density + 0.5f).toInt()
}


fun Int.toPx(context: Context): Int{
    return (this * context.displayMetrics.density + 0.5f).toInt()
}


//fun Context.toast


fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun androidx.fragment.app.FragmentActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}


fun androidx.fragment.app.FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{replace(frameId, fragment)}
}
