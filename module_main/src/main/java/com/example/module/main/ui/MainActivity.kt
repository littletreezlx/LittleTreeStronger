package com.example.module.main.ui


import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.navigation.findNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.base.BaseActivity
import com.example.common.base.BaseFragment
import com.example.module.main.R
import com.example.module.main.adapter.ViewPagerAdapter
import com.example.module.main.kodein.exerciseTimeDiModule
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


@Route(path = "/main/main")
class MainActivity : BaseActivity(), KodeinAware {


//    val instance by lazy { this }

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val parentKodein by kodein()

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)
        import(exerciseTimeDiModule)
        bind<MainActivity>() with instance(this@MainActivity)
    }


    private val onBottomNavigationViewClickedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId){
            R.id.main -> {
                viewpager.currentItem = 0
                true
            }
            R.id.discovery -> {
                viewpager.currentItem = 1
                true
            }
            R.id.community -> {
                viewpager.currentItem = 0
                true
            }
            R.id.me -> {
                viewpager.currentItem = 1
                true
            }
            else -> {
                false
            }
        }
//        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = viewPagerAdapter
        bottom_navigationview.setOnNavigationItemSelectedListener(onBottomNavigationViewClickedListener)

//        bottom_navigationview.setupWithNavController(findNavController(R.id.bottom_navigationview))

        requestPermissions()
    }


    override fun onResume() {
        super.onResume()
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottomnavigationview)
//        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)

    }


    fun requestPermissions(){
        RxPermissions(this)
            .requestEach(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
            )
            .subscribe { permission ->
                if (permission.granted) {
                    //agree
//                    onGranted()
                } else {
                    showDialog(permission.name)
                }
            }
//            .subscribe(new Consumer<Permission>() {
//                @Override
//                public void accept(Permission permission) throws Exception {
//                    if (permission.granted) {
//                        // 用户已经同意该权限
//                        Log.d(TAG, permission.name + " is granted.");
//                    } else if (permission.shouldShowRequestPermissionRationale) {
//                        // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
//                        Log.d(TAG, permission.name + " is denied. More info should be provided.");
//                    } else {
//                        // 用户拒绝了该权限，并且选中『不再询问』
//                        Log.d(TAG, permission.name + " is denied.");
//                    }
//                }
//            });


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



    override fun onSupportNavigateUp()
            = findNavController(when (viewpager.currentItem){
        0 -> R.id.fragment_container_main
        1 -> R.id.fragment_container_discovery
        else -> R.id.fragment_container_main
        }).navigateUp()



    override fun onBackPressed() {
//        super.onBackPressed()

//        val a = findNavController(when (viewpager.currentItem){
//            0 -> R.id.fragment_container_main
//            1 -> R.id.fragment_container_discovery
//            else -> R.id.fragment_container_main
//        })
//        a.navigateUp()
//
//
        val topFragment = viewPagerAdapter.getTopFragment(viewpager.currentItem) as BaseFragment
        topFragment.navigateUp()
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
