package com.example.module.time

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.MyApplication
import com.example.module.time.data.ExerciseRecord
import com.example.module.time.repository.ExerciseRecordRepository

class ExerciseTimeViewModel : ViewModel(){

    private lateinit var exerciseRecords: MutableLiveData<ArrayList<ExerciseRecord>>

    fun getExerciseRecords(): MutableLiveData<ArrayList<ExerciseRecord>> {
        if (!::exerciseRecords.isInitialized) {
            exerciseRecords = MutableLiveData()
            loadEexerciseRecords()
        }
        return exerciseRecords
    }



    //从数据库中查找一天的锻炼中前面的记录
    private fun loadEexerciseRecords() {


//        exerciseRecords.value = arrayListOf()



        exerciseRecords.value = ExerciseRecordRepository.getInstance(AppDatabase.getInstance()).getExerciseRecordByDate().value


    }

}