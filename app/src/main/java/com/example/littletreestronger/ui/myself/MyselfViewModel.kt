/*
 * Copyright - LittleTree (c) 2019.
 */

package com.example.littletreestronger.ui.myself

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.model.TYPE_MEAL_BREAKFAST
import com.example.littletreestronger.data.model.TYPE_MEAL_DINNER
import com.example.littletreestronger.data.model.TYPE_MEAL_LUNCH
import com.example.littletreestronger.data.repository.DietRecordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import kotlin.concurrent.thread

/**
 *@Author LittleTree
 *@CreateTime 2019/10/29 11:05
 *@Description viewmodel
 */
class MyselfViewModel(

) : ViewModel(){



    private val _myName = MutableLiveData<String>()
    val myName: LiveData<String> = _myName


    fun updateName() {
        viewModelScope.launch {
            val deferred =  async(Dispatchers.IO) {
                getData()
            }
            val response = deferred.await()
            _myName.value = response
        }

    }


    fun getData(): String{
        Thread.sleep(5000)
        return "111"
    }


}