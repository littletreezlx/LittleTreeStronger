/*
 * Copyright - LittleTree (c) 2019.
 */
package com.example.littletreestronger.data

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean


/**
 *@Author zlx
 *@CreateTime 2019/11/2 14:49
 *@Description 防止数据倒灌
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)



    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)

        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }
        // Observe the internal MutableLiveData
        super.observe(owner, object : Observer<T> {
            override fun onChanged(t: T) {
                if (mPending.compareAndSet(true, false)) {
                    observer.onChanged(t)
                }
            }
        }
        )
    }



    @MainThread
    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        setValue(null)
    }

    companion object {

        private val TAG = "SingleLiveEvent"
    }

}