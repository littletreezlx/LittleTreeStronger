package com.example.littletreestronger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.littletreestronger.data.model.ExerciseRecord
import com.example.littletreestronger.data.repository.ExerciseRecordRepository
import org.jetbrains.anko.AnkoLogger
import java.util.*

class ExerciseRecordViewModel(
    private val repo: ExerciseRecordRepository
) : ViewModel(){



    companion object {
        private const val PAGE_SIZE = 15
        private const val ENABLE_PLACEHOLDERS = false
    }


    private  var exerciseRecords =  MutableLiveData<List<ExerciseRecord>>()


    fun getExerciseRecords(): LiveData<PagedList<ExerciseRecord>> {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
            .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
            .build()

        val records = LivePagedListBuilder(repo.getExerciseRecordByDate(Calendar.getInstance()), config).build()
        return records
//        return repo.getExerciseRecordByDate(Calendar.getInstance())
    }


    //从数据库中查找一天的锻炼中前面的记录
//    private fun loadEexerciseRecords() {
////        exerciseRecords.value = arrayListOf()
////        exerciseRecords.value = ExerciseRecordRepository.getInstance(AppDatabase.getInstance().exerciseRecordDao()).getExerciseRecordByDate().value
//
////        exerciseRecords = repo.getExerciseRecordByDate(Calendar.getInstance())
//        exerciseRecords.value = repo.getExerciseRecordByDate(Calendar.getInstance()).value
//        //
////        if (exerciseRecords.value == null){
////            exerciseRecords = MutableLiveData()
////        }
////        exerciseRecords.value!!.add(ExerciseRecord("TestAnnotation",0))
//    }


    private val log = AnkoLogger(this.javaClass)


    //test
     fun addExerciseRecords(){
        repo.insertExerciseRecord(ExerciseRecord.mockExerciseRecord())
    }

}