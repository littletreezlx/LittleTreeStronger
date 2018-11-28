package com.example.module.main.ui


import android.content.Intent
import android.os.Bundle
import android.view.ViewManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.common.BaseActivity
import org.jetbrains.anko.verticalLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.module.main.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.internal.Internal.instance
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk27.coroutines.onClick


@Route(path = "/main/main")
class MainActivity : BaseActivity() {

    lateinit var navHostFragment : NavHostFragment

    val instance by lazy { this }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {


            button("say hello"){
                onClick {
                    toast("hello!")


                    ARouter.getInstance().build("/share/share").navigation()


                }
            }

//            linearLayout {
//                id = R.id.main_navhostfragment
////                supportFragmentManager.beginTransaction()
////                    .replace(R.id.main_navhostfragment, finalHost)
////                    .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
////                    .commit()
//            }

            navHostFragment = NavHostFragment.create(R.navigation.main_navigation)

            linearLayout {
                id = R.id.main_navhostfragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_navhostfragment, navHostFragment)
                    .setPrimaryNavigationFragment(navHostFragment) // this is the equivalent to app:defaultNavHost="true"
                    .commit()
            }.lparams {
                width = matchParent
                height = dip(300)
            }

            bottomNavigationView {
                id = R.id.main_bottomnavigationview
            }.lparams{
                width = matchParent
                height = dip(100)
            }

        }

        //        MainActivityUI().setContentView(this)


//        val finalHost = NavHostFragment.create(R.navigation.main_navigation)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_navhostfragment, finalHost)
//            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
//            .commit()

//        Navigation.setViewNavController(window.decorView, finalHost.navController);
//        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.main_navhostfragment) as NavHostFragment


//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottomnavigationview)
//        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)




        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottomnavigationview)

    }


    override fun onResume() {
        super.onResume()

//        val navController = findNavController(R.id.main_navhostfragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottomnavigationview)
        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)

    }

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.main_navhostfragment).navigateUp()

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String
//
//    companion object {
//
//        // Used to load the 'native-lib' library on application startup.
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }
}


//class MainActivityUI : AnkoComponent<MainActivity> {
//
//    override fun createView(ui: AnkoContext<MainActivity>) =  ui.apply {
//        verticalLayout {
//
//            val name = editText()
//            button("say hello"){
//                onClick {
//                    ctx.toast("hello, ${name.text}!")
//                    Navigation.findNavController(it!!).navigate(R.id.settingFragment2)
//                }
//            }
//
//            linearLayout {
//                id = 1
//            }
//
//            include<View>(R.layout.main_navhostfragment)
//        }
//    }.view
//}




//
//inline fun ViewManager.fragment(theme : Int = 0) = NavHostFragment()
//
//inline fun ViewManager.fragment(theme : Int = 0, init : NavHostFragment.() -> Unit) : NavHostFragment{
//    return  ankoView({NavHostFragment(it)}, theme, init)
//}


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
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


public inline fun ViewManager.bottomNavigationView(theme: Int = 0) = bottomNavigationView(theme) {}

public inline fun ViewManager.bottomNavigationView(theme: Int = 0, init: BottomNavigationView.() -> Unit) = ankoView({ BottomNavigationView(it) }, theme, init)




//private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//    when (item.itemId) {
//        R.id.navigation_home -> {
////                message.setText(R.string.title_home)
//            return@OnNavigationItemSelectedListener true
//        }
//        R.id.navigation_dashboard -> {
////                message.setText(R.string.title_dashboard)
//
//            return@OnNavigationItemSelectedListener true
//        }
//        R.id.navigation_notifications -> {
////                message.setText(R.string.title_notifications)
//            return@OnNavigationItemSelectedListener true
//        }
//    }
//    false
//}
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_bottom)
//
//    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//}


//navigation.setOnNavigationItemSelectedListener {item ->
//
//    onNavDestinationSelected(item, Navigation.findNavController(this, R.id.my_nav_host_fragment))
//
//}
