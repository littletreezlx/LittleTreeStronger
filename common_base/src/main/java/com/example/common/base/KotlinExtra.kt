package com.example.common.base

import android.content.Context
import android.os.Build
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.jetbrains.anko.displayMetrics



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


//沉浸状态栏
fun AppCompatActivity.steepStatusBar(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // 透明状态栏
        window.addFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
        getWindow().addFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
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
