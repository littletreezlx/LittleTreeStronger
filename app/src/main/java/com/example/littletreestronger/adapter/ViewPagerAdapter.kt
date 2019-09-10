package com.example.littletreestronger.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.littletreestronger.ui.community.ContainerCommunityFragment
import com.example.littletreestronger.ui.diet.ContainerDietFragment
import com.example.littletreestronger.ui.exercise.ContainerExerciseFragment
import com.example.littletreestronger.ui.myself.ContainerMyselfFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private lateinit var topFragment: Fragment

    private lateinit var dietFragment: Fragment

    private lateinit var exerciseFragment: Fragment

    private lateinit var communityFragment: Fragment

    private lateinit var myselfFragment: Fragment


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                dietFragment = ContainerDietFragment()
                dietFragment
            }
            1 ->{
                exerciseFragment =
                    ContainerExerciseFragment()
                exerciseFragment
            }
            2 -> {
                communityFragment =
                    ContainerCommunityFragment()
                communityFragment
            }
            3 -> {
                myselfFragment = ContainerMyselfFragment()
                myselfFragment
            }
            else -> {
                dietFragment = ContainerDietFragment()
                dietFragment
            }
        }
    }


    override fun getCount(): Int {
        return 4
    }

    fun getTopFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                dietFragment
            }
            1 ->{
                exerciseFragment
            }
            2 -> {
                communityFragment
            }
            3 -> {
                myselfFragment
            }
            else -> {
                dietFragment
            }
        }
    }


}