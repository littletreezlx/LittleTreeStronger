package com.example.littletreestronger.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.littletreestronger.base.BaseFragment
import com.example.littletreestronger.R
import com.example.littletreestronger.view.PercentView
import kotlinx.android.synthetic.main.fragment_community.*


class CommunityFragment : BaseFragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }

//    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_community, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        percent_view.percent = 130
//        percent_view.invalidate()

    }


}
