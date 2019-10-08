package com.example.littletreestronger.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import timber.log.Timber





open class BaseDialogFragment : DialogFragment(), KodeinAware {


    override val kodein by kodein()

//    private val TAG = this.javaClass.name

    private val TAG by lazy {
        this.javaClass.name + "___LifeCycle___"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("%sonAttach",TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("%sonCreate",TAG)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("%sonCreateView",TAG)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("%sonViewCreated",TAG)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("%sonStart",TAG)
    }

    override fun onResume() {
        super.onResume()
        Timber.d("%sonResume",TAG)
    }

    override fun onPause() {
        super.onPause()
        Timber.d("%sonPause",TAG)
    }

    override fun onStop() {
        super.onStop()
        Timber.d("%sonStop",TAG)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("%sonDestroyView",TAG)
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("%sonDestroy",TAG)
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("%sonDetach",TAG)
    }



}