package com.example.littletreestronger

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.view.View
import android.widget.RemoteViews
import org.jetbrains.anko.notificationManager

class DeepWorkoutService : Service() {

    lateinit var instance: DeepWorkoutService




    val binder by lazy {
        DeepWorkoutBinder()
    }

    inner class DeepWorkoutBinder : Binder() {
        val service: DeepWorkoutService
            get() = this@DeepWorkoutService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }


    override fun onCreate() {
        super.onCreate()

        addNotification()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }




    override fun onDestroy() {
        super.onDestroy()
    }


    @TargetApi(26)
    fun addNotification() {
        if (Build.VERSION.SDK_INT < 26){
            return
        }
        val intent = Intent(this, DeepWorkoutService::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val intentPlay = Intent(this, DeepWorkoutService::class.java)
        intentPlay.putExtra("mode", "start")
        val pendingIntentPlay = PendingIntent.getService(this, 1, intentPlay, PendingIntent.FLAG_UPDATE_CURRENT
        )
        val remoteViews = RemoteViews(packageName, R.layout.notification)
        remoteViews.setOnClickPendingIntent(R.id.btn, pendingIntentPlay)

        val notification = Notification.Builder(this,"channel")
            .setTicker("欢迎使用小树音乐")
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .setCustomContentView(remoteViews)
            .build()

        updateRemoteViews()
        startForeground(1, notification)
    }

    fun updateRemoteViews() {

    }
}
