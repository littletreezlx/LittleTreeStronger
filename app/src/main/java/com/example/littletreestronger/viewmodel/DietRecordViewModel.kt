package com.example.littletreestronger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.littletreestronger.constants.ExerciseActionEnum
import com.example.littletreestronger.data.AppDatabase
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.model.ExerciseRecord
import com.example.littletreestronger.data.repository.DietRecordRepository
import com.example.littletreestronger.data.repository.ExerciseRecordRepository
import org.jetbrains.anko.AnkoLogger
import java.util.*
import kotlin.random.Random

class DietRecordViewModel(
    private val repo: DietRecordRepository
) : ViewModel(){

    companion object {
        private const val PAGE_SIZE = 15
        private const val ENABLE_PLACEHOLDERS = false
    }

    val config = PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
        .build()

    fun getDietRecords(): LiveData<PagedList<DietRecord>> {
        val records = LivePagedListBuilder(repo.getDietRecordByDate(Calendar.getInstance()), config).build()
        return records
    }

    fun getBreakfastDietRecords(): LiveData<PagedList<DietRecord>> {
        return LivePagedListBuilder(repo.getBreakfastDietRecordByDate(Calendar.getInstance()), config).build()
    }

    fun getLunchfastDietRecords(): LiveData<PagedList<DietRecord>> {
        return LivePagedListBuilder(repo.getLunchDietRecordByDate(Calendar.getInstance()), config).build()
    }


    fun addDietRecords(){
        repo.insertDietRecord(DietRecord.mockDietRecord())
    }

//    //test
//     fun addExerciseRecords(){
//        repo.insertExerciseRecord(
//            ExerciseRecord(
//                ExerciseActionEnum.values().run {
//                    this.get(Random.nextInt(this.size))
//                }.chineseName,
//                Random.nextInt(100),
//                Random.nextInt(12)
//            )
//        )
//    }

}