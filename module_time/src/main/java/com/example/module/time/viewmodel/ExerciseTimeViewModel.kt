package com.example.module.time.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.module.time.ExerciseActionEnum
import com.example.module.time.data.ExerciseRecord
import com.example.module.time.repository.ExerciseRecordRepository
import org.jetbrains.anko.AnkoLogger
import java.util.*
import kotlin.random.Random

class ExerciseTimeViewModel(
    private val repo: ExerciseRecordRepository
) : ViewModel(){


    private lateinit var exerciseRecords: LiveData<List<ExerciseRecord>>


    //init
    fun getExerciseRecords(): LiveData<List<ExerciseRecord>> {
        if (!::exerciseRecords.isInitialized) {

//            exerciseRecords = MutableLiveData()
            loadEexerciseRecords()
        }


        return exerciseRecords
    }



    //从数据库中查找一天的锻炼中前面的记录
    private fun loadEexerciseRecords() {


//        exerciseRecords.value = arrayListOf()

//        exerciseRecords.value = ExerciseRecordRepository.getInstance(AppDatabase.getInstance().exerciseRecordDao()).getExerciseRecordByDate().value

        exerciseRecords = repo.getExerciseRecordByDate(Calendar.getInstance())


        //
//        if (exerciseRecords.value == null){
//            exerciseRecords = MutableLiveData()
//        }


//        exerciseRecords.value!!.add(ExerciseRecord("a",0))
    }


    private val log = AnkoLogger(this.javaClass)


    //test
    public fun addExerciseRecords(){

        repo.insertExerciseRecord(ExerciseRecord(
            ExerciseActionEnum.YINGLA.chineseName,
            Random.nextInt()
        ))
        repo.insertExerciseRecord(ExerciseRecord(
            ExerciseActionEnum.SHENDUN.chineseName,
            Random.nextInt()
        ))
        repo.insertExerciseRecord(ExerciseRecord(
            ExerciseActionEnum.WOTUI.chineseName,
            Random.nextInt()
        ))

//        log.debug(repo.getExerciseRecordByDate(Calendar.getInstance()).value!!.size)


    }

}