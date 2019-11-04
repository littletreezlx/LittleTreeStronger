package com.example.littletreestronger.viewmodel

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
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

/**
 *@Author LittleTree
 *@CreateTime 2019/10/29 11:05
 *@Description viewmodel
 */
class DietRecordViewModel(
    private val repo: DietRecordRepository
) : ViewModel(){

    companion object {
        private const val PAGE_SIZE = 15
        private const val ENABLE_PLACEHOLDERS = false
    }

    val config by lazy {
        PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
            .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
            .build()
    }

    lateinit var breakfastRecords: LiveData<PagedList<DietRecord>>
    lateinit var lunchRecords: LiveData<PagedList<DietRecord>>
    lateinit var dinnerRecords: LiveData<PagedList<DietRecord>>


    val calorySum: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = 0 }
    var proteinSum: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = 0 }
    var fatSum: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = 0 }
    var carbohydrateSum: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = 0 }


//    fun getDietRecords(): LiveData<PagedList<DietRecord>> {
//        val records = LivePagedListBuilder(repo.getDietRecordByDate(Calendar.getInstance()), config).build()
//        return records
//    }


    //tbd
//    fun getBreakfastDietRecords(): LiveData<PagedList<DietRecord>> {
//        lateinit var record: DataSource.Factory<Int, DietRecord>
//        viewModelScope.launch {
//            record = repo.getBreakfastDietRecordByDate(Calendar.getInstance())
//        }
//        return LivePagedListBuilder(record, config).build()
//    }
//
//    fun getLunchDietRecords(): LiveData<PagedList<DietRecord>> {
//        return LivePagedListBuilder(repo.getLunchDietRecordByDate(Calendar.getInstance()), config).build()
//    }
//
//    fun getDinnerDietRecords(): LiveData<PagedList<DietRecord>> {
//        return LivePagedListBuilder(repo.getLunchDietRecordByDate(Calendar.getInstance()), config).build()
//    }


    /**
     *@Description get DietRecords by mealType(breakfast...)
     */
    fun getDietRecords(mealType: Int): LiveData<PagedList<DietRecord>> {
        //默认异步？
//        lateinit var dietRecord: LiveData<PagedList<DietRecord>>
//        viewModelScope.launch {
//            dietRecord = LivePagedListBuilder(repo.getDietRecordByDateAndMealType(Calendar.getInstance(), mealType), config).build()
//        }
//        return dietRecord
        val livedata = LivePagedListBuilder(repo.getDietRecordByDateAndMealType(Calendar.getInstance(), mealType), config).build()
        when (mealType){
            TYPE_MEAL_BREAKFAST ->  breakfastRecords = livedata
            TYPE_MEAL_LUNCH ->  lunchRecords = livedata
            TYPE_MEAL_DINNER ->  dinnerRecords = livedata
        }
        return livedata
//        return LivePagedListBuilder(repo.getDietRecordByDateAndMealType(Calendar.getInstance(), mealType), config).build()
    }


    //todo: to improve
    fun addDietRecords(record: DietRecord){
//        val record = DietRecord.mockDietRecord(mealType)
        repo.insertDietRecord(record)

        calorySum.value = calorySum.value?.plus(record.calories)
        proteinSum.value = proteinSum.value?.plus(record.protein)
        fatSum.value = fatSum.value?.plus(record.fat)
        carbohydrateSum.value = carbohydrateSum.value?.plus(record.carbohydrate)

        Timber.d("calorySum" + calorySum.value + record.calories)
    }


    private fun onRecordsChanged(){

    }




}