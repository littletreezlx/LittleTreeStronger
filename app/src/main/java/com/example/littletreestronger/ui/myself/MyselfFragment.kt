package com.example.littletreestronger.ui.myself

import android.os.Bundle
import android.os.Looper
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.littletreestronger.common.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.ui.diet.DietFragmentDirections
import kotlinx.android.synthetic.main.diet_fragment.*
import kotlinx.android.synthetic.main.myself_fragment.*
import kotlin.concurrent.thread


class MyselfFragment : BaseFragment() {

    companion object {
        fun newInstance() = MyselfFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.myself_fragment, container, false)


        val i =1
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        tv_myself_test.requestLayout()
    }

}
