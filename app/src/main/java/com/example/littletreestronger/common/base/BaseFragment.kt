package com.example.littletreestronger.common.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


open class BaseFragment : Fragment(), KodeinAware {


//    val job = Job()

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job

    override val kodein by kodein()

//    private val TAG = this.javaClass.name

     val TAG by lazy {
        this.javaClass.name + "___LifeCycle___"
     }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Timber.d("$TAG onAttach")
//    }
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Timber.d("$TAG onCreate")
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Timber.d("$TAG onCreateView")
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        Timber.d("$TAG onViewCreated")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Timber.d("$TAG onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Timber.d("$TAG onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Timber.d("$TAG onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Timber.d("$TAG onStop")
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Timber.d("$TAG onDestroyView")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        job.cancel()
//        Timber.d("$TAG onDestroy")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Timber.d("$TAG onDetach")
//    }



}