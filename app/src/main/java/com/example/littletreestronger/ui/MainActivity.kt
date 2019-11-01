package com.example.littletreestronger.ui

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.system.Os.accept
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.littletreestronger.R
import com.example.littletreestronger.adapter.ViewPagerAdapter
import com.example.littletreestronger.common.base.BaseActivity
import com.example.littletreestronger.common.base.setStatusBarFullTransparent
import com.example.littletreestronger.di.dietTimeDiModule
import com.example.littletreestronger.di.exerciseDiModule
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.main_activity.*
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity(), KodeinAware {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val parentKodein by kodein()

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)
        import(exerciseDiModule)
        import(dietTimeDiModule)
        bind<MainActivity>() with instance(this@MainActivity)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.BaseTheme)

        super.onCreate(savedInstanceState)
//        setStatusBarColor(R.color.full_translucent)
        setContentView(R.layout.main_activity)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = viewPagerAdapter

        viewpager.offscreenPageLimit = 4

        bottom_navigationview.setOnNavigationItemSelectedListener(onBottomNavigationViewClickedListener)
        requestPermissions()

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                bottom_navigationview.let {
                    it.selectedItemId= it.menu.getItem(position).getItemId()
                }
            }
        })

        setSupportActionBar(toolbar as Toolbar)
        setStatusBarFullTransparent()


//        steepStatusBar()
//        setStatusBarColor(R.color.toolbar_background)
    }






    override fun onResume() {
        super.onResume()
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottomnavigationview)
//        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)

        val i =1
    }


    private val onBottomNavigationViewClickedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId){
            R.id.diet -> {
                viewpager.currentItem = 0
                true
            }
            R.id.exercise -> {
                viewpager.currentItem = 1
//                bottom_navigationview.selectedItemId = R.id.exercise
                true
            }
            R.id.community -> {
                viewpager.currentItem = 2
                true
            }
            R.id.myself -> {
                viewpager.currentItem = 3
                true
            }
            else -> {
                false
            }
        }
//        navigation.getMenu().getItem(position).getItemId());
//        false
    }


    fun requestPermissions(){
        val dispose = RxPermissions(this)
            .requestEach(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
            )
            .subscribe { permission ->
                if (permission.granted) {
//                    onGranted()
                    Log.d(TAG, permission.name + " is granted.")
                }
                else if (permission.shouldShowRequestPermissionRationale){
                    // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                    Log.d(TAG, permission.name + " is denied. More info should be provided.");
                }
                else {
                    Log.d(TAG, permission.name + " is denied.");
                    showDialog(permission.name)
                }
            }
    }


    fun showDialog(permissionName : String){
        val keylistener = DialogInterface.OnKeyListener { _, keyCode, event ->
            keyCode == KeyEvent.KEYCODE_BACK && event.repeatCount == 0
        }

        var dialog = AlertDialog.Builder(this)
            .setTitle("权限申请")
            .setMessage("${permissionName}为必选项，开通后方可正常使用APP,请在设置中开启。")
            .setOnKeyListener(keylistener)
            .setCancelable(false)
            .setPositiveButton("去开启") { _, _ ->
                //                                JumpPermissionManagement.GoToSetting(this)
                finish()
            }
            .setNegativeButton("结束") { _, _ ->
                Toast.makeText(this, "${permissionName}权限未开启，不能使用该功能！", Toast.LENGTH_SHORT).show()
                finish()
            }
            .create()

        dialog.show()
    }


    private fun initToolbar() {
//        setSupportActionBar(toolbar)
//                ActionMenuView actionMenuView = (ActionMenuView) toolbar.findViewById(R.id.action_menu_view);
//                getMenuInflater().inflate(R.menu.main_menu, actionMenuView.getMenu());
//                actionMenuView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        startActivity(new Intent(MainActivity.this, AMapDebugActivity.class));
//                    }
//                });
//
//                actionMenuView.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        return false;
//                    }
//                });
//                toolbar.showOverflowMenu();
    }

//    override fun onSupportNavigateUp() =
//        findNavController(
//        when (viewpager.currentItem){
//        0 -> R.id.fragment_nav_host_diet
//        1 -> R.id.fragment_nav_host_exercise
//        2 -> R.id.fragment_nav_host_community
//        3 -> R.id.fragment_nav_host_myself
//        else -> R.id.fragment_nav_host_diet
//        }).navigateUp()


    override fun onBackPressed() {
//        val topFragment = viewPagerAdapter.getTopFragment(viewpager.currentItem) as BaseFragment
//        topFragment.navigateUp()
        if (!navigateUp()){
            val intent = Intent().run {
                action = "android.intent.action.MAIN"
                addCategory("android.intent.category.HOME")
                addCategory("android.intent.category.DEFAULT")
                addCategory("android.intent.category.MONKEY")
            }
            startActivity(intent)
        }
    }


    fun navigateUp() : Boolean{
        return findNavController(
            when (viewpager.currentItem){
                0 -> R.id.fragment_nav_host_diet
                1 -> R.id.fragment_nav_host_exercise
                2 -> R.id.fragment_nav_host_community
                3 -> R.id.fragment_nav_host_myself
                else -> R.id.fragment_nav_host_diet
            }).navigateUp()
    }




}









//ARouter.getInstance().build("/time/exercise").navigation()
//    navHostFragment = NavHostFragment.create(R.navigation.main_navigation)
//    linearLayout {
//        id = R.id.main_navhostfragment
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_navhostfragment, navHostFragment)
//            .setPrimaryNavigationFragment(navHostFragment) // this is the equivalent to app:defaultNavHost="true"
//            .commit()
//    }.lparams {
//        width = matchParent
//        height = matchParent
//    }
