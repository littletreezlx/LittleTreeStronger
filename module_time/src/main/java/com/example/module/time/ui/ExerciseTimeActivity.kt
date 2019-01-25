package com.example.module.time.ui

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.base.BaseActivity
import com.example.module.time.R
import com.example.module.time.data.ExerciseRecord
import com.example.module.time.di.exerciseTimeDiModule
import com.example.module.time.viewmodel.ExerciseTimeViewModel
import com.google.gson.Gson
import com.tbruyelle.rxpermissions2.RxPermissions
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


@Route(path = "/time/exercise")
class ExerciseTimeActivity: BaseActivity(), KodeinAware{


//    <uses-permission android:name="android.permission.BLUETOOTH" />
//    <uses-permission android:name="android.permission.INTERNET" />
//    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
//    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
//    <!-- Required to check if WiFi is enabled -->
//    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
//    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
//    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
//    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
//    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
//    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
//    <uses-permission android:name="android.permission.WAKE_LOCK" />

    private val parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)

        import(exerciseTimeDiModule)
        bind<ExerciseTimeActivity>() with instance(this@ExerciseTimeActivity)

    }


    private val viewModel: ExerciseTimeViewModel by instance()

    private val gson: Gson by instance()



    lateinit var recordAdapter: ExerciseRecordAdapter


//    val viewModel : ExerciseTimeViewModel by lazy {
//        ViewModelProviders.of(this).get(ExerciseTimeViewModel::class.java)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        verticalLayout {

            recyclerView {
                id = R.id.time_recyclerview

                layoutManager = LinearLayoutManager(this@ExerciseTimeActivity)

//                recordAdapter = ExerciseRecordAdapter(arrayListOf(ExerciseRecord("a",0), ExerciseRecord("b",1)))
                recordAdapter = ExerciseRecordAdapter(viewModel.getExerciseRecords().value)

                adapter = recordAdapter
            }.lparams{
                width = matchParent
                height = dip(300)
            }


            button{
                text = "click this"
                onClick {

                    info { "info" + "ccc" }
                    debug("a")
//                    recordAdapter.updateList()
//                    recordAdapter.notifyDataSetChanged()

//                    viewModel.getExerciseRecords().apply {
//
//                        value = value?.apply {
//                            add(
//                                ExerciseRecord(
//                                    ExerciseActionEnum.YINGLA.chineseName,
//                                    Random.nextInt()
//                                )
//                            )
//                            add(
//                                ExerciseRecord(
//                                    ExerciseActionEnum.SHENDUN.chineseName,
//                                    Random.nextInt()
//                                )
//                            )
//                            add(
//                                ExerciseRecord(
//                                    ExerciseActionEnum.WOTUI.chineseName,
//                                    Random.nextInt()
//                                )
//                            )
//                        }
//                    }
                    viewModel.addExerciseRecords()
                }
            }.lparams{
                width = matchParent
                height = dip(100)
            }
        }

        viewModel.getExerciseRecords().observe(this, Observer <List<ExerciseRecord>>{ exerciseRecords ->
            recordAdapter.notifyDataSetChanged()
        })



        requestPermissions()

//        val viewModel = ViewModelProviders.of(this).get(ExerciseTimeViewModel::class.java)
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


    //传入权限与权限描述，在需要权限的功能打开之前调用
    fun requestPermissions(vararg permissions: String, describe: String, onGranted:()->Unit) {
//        val keylistener = DialogInterface.OnKeyListener { _, keyCode, event ->
//            keyCode == KeyEvent.KEYCODE_BACK && event.repeatCount == 0
//        }
//
//        var dialog = AlertDialog.Builder(this)
//            .setTitle("权限申请")
//            .setMessage("${describe}为必选项，开通后方可正常使用APP,请在设置中开启。")
//            .setOnKeyListener(keylistener)
//            .setCancelable(false)
//            .setPositiveButton("去开启") { _, _ ->
//                //                JumpPermissionManagement.GoToSetting(this)
//                finish()
//            }
//            .setNegativeButton("结束") { _, _ ->
//                Toast.makeText(this, "${describe}权限未开启，不能使用该功能！", Toast.LENGTH_SHORT).show()
//                finish()
//            }
//            .create()
    }


}