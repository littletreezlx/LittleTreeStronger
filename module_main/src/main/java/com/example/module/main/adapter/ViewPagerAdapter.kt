package com.example.module.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.module.main.ui.ContainerDiscoveryFragment
import com.example.module.main.ui.ContainerMainFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private lateinit var topFragment: Fragment

    private lateinit var mainFragment: Fragment

    private lateinit var discoveryFragment: Fragment

    private lateinit var communityFragment: Fragment

    private lateinit var meFragment: Fragment


    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                mainFragment = ContainerMainFragment()
                mainFragment
            }
            1 ->{
                discoveryFragment = ContainerDiscoveryFragment()
                discoveryFragment
            }
            2 -> {
                communityFragment = ContainerMainFragment()
                communityFragment
            }
            3 -> {
                meFragment = ContainerDiscoveryFragment()
                meFragment
            }
            else -> {
                mainFragment = ContainerMainFragment()
                mainFragment
            }
        }

    }


    override fun getCount(): Int {
        return 4
    }


    fun getTopFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                mainFragment
            }
            1 ->{
                discoveryFragment
            }
            2 -> {
                communityFragment
            }
            3 -> {
                meFragment
            }
            else -> {
                mainFragment
            }
        }
    }


}