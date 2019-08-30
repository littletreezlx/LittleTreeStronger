package com.example.littletreestronger.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.littletreestronger.MyApplication


class ExercisePlanViewModel() : AndroidViewModel(MyApplication.instance as Application){


    private val exercisePlanNameList = MutableLiveData<MutableList<String>>()


    fun getExercisePlanNameList(): LiveData<MutableList<String>> {
        return exercisePlanNameList
    }

    fun addExercisePlanName(planName: String){
        exercisePlanNameList.value?.let {
            it.add(planName)
        }
    }



}