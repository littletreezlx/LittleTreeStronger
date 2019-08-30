package com.example.littletreestronger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.littletreestronger.constants.ExerciseActionEnum
import com.example.littletreestronger.data.model.ExerciseRecord
import com.example.littletreestronger.data.repository.ExerciseRecordRepository
import org.jetbrains.anko.AnkoLogger
import java.util.*
import kotlin.random.Random

class ExerciseTimeViewModel(
    private val repo: ExerciseRecordRepository
) : ViewModel(){


    private  var exerciseRecords =  MutableLiveData<List<ExerciseRecord>>()



    //expected expose a unMutableLiveData
    fun getExerciseRecords(): LiveData<List<ExerciseRecord>> {
//        loadEexerciseRecords()
//        return exerciseRecords
        return repo.getExerciseRecordByDate(Calendar.getInstance())
    }


    //从数据库中查找一天的锻炼中前面的记录
    private fun loadEexerciseRecords() {
//        exerciseRecords.value = arrayListOf()
//        exerciseRecords.value = ExerciseRecordRepository.getInstance(AppDatabase.getInstance().exerciseRecordDao()).getExerciseRecordByDate().value

//        exerciseRecords = repo.getExerciseRecordByDate(Calendar.getInstance())
        exerciseRecords.value = repo.getExerciseRecordByDate(Calendar.getInstance()).value
        //
//        if (exerciseRecords.value == null){
//            exerciseRecords = MutableLiveData()
//        }
//        exerciseRecords.value!!.add(ExerciseRecord("a",0))
    }


    private val log = AnkoLogger(this.javaClass)


    //test
    public fun addExerciseRecords(){
        repo.insertExerciseRecord(
            ExerciseRecord(
                ExerciseActionEnum.values().run {
                    this.get(Random.nextInt(this.size))
                }.chineseName,
                Random.nextInt(100),
                Random.nextInt(12)
            )
        )
    }

}