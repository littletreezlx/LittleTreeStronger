package com.example.littletreestronger.common.base




//fun requestPermissions(){
//    RxPermissions(this)
//        .requestEach(
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_PHONE_STATE
//        )
//        .subscribe { permission ->
//            if (permission.granted) {
//                //agree
////                    onGranted()
//            } else {
//                showDialog(permission.name)
//            }
//        }
////            .subscribe(new Consumer<Permission>() {
////                @Override
////                public void accept(Permission permission) throws Exception {
////                    if (permission.granted) {
////                        // 用户已经同意该权限
////                        Log.d(TAG, permission.name + " is granted.");
////                    } else if (permission.shouldShowRequestPermissionRationale) {
////                        // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
////                        Log.d(TAG, permission.name + " is denied. More info should be provided.");
////                    } else {
////                        // 用户拒绝了该权限，并且选中『不再询问』
////                        Log.d(TAG, permission.name + " is denied.");
////                    }
////                }
////            });
//
//
//}
//
//
//
//fun showDialog(permissionName : String){
//    val keylistener = DialogInterface.OnKeyListener { _, keyCode, event ->
//        keyCode == KeyEvent.KEYCODE_BACK && event.repeatCount == 0
//    }
//
//    var dialog = AlertDialog.Builder(this)
//        .setTitle("权限申请")
//        .setMessage("${permissionName}为必选项，开通后方可正常使用APP,请在设置中开启。")
//        .setOnKeyListener(keylistener)
//        .setCancelable(false)
//        .setPositiveButton("去开启") { _, _ ->
//            //                                JumpPermissionManagement.GoToSetting(this)
//            finish()
//        }
//        .setNegativeButton("结束") { _, _ ->
//            Toast.makeText(this, "${permissionName}权限未开启，不能使用该功能！", Toast.LENGTH_SHORT).show()
//            finish()
//        }
//        .create()
//
//    dialog.show()
//}