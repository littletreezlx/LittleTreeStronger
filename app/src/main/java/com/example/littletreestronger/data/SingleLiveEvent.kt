/*
 * Copyright - LittleTree (c) 2019.
 */
package com.example.littletreestronger.data

import android.util.Log
import androidx.annotation.MainThread
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.atomic.AtomicBoolean


class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    @MainThread
    fun observe(owner: LifecycleOwner, observer: Observer<T>) {

        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }

        // Observe the internal MutableLiveData
        super.observe(owner, object : Observer<T>() {
            fun onChanged(@Nullable t: T) {
                if (mPending.compareAndSet(true, false)) {
                    observer.onChanged(t)
                }
            }
        })
    }


    @MainThread
    override fun setValue(@Nullable t: T?) {
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