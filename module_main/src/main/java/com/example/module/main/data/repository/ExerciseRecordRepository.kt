package com.example.module.main.data.repository

import com.example.common.util.runOnIoThread
import com.example.module.main.data.dao.ExerciseRecordDao
import com.example.module.main.data.model.ExerciseRecord
import java.util.*


class ExerciseRecordRepository

    private constructor(private val exerciseRecordDao: ExerciseRecordDao)
{

    fun insertExerciseRecord(exerciseRecord: ExerciseRecord) {
        runOnIoThread {
            exerciseRecordDao.insertExerciseRecord(exerciseRecord)
        }
    }

    fun deleteExerciseRecord(exerciseRecord: ExerciseRecord) {
        runOnIoThread {
            exerciseRecordDao.deleteExerciseRecord(exerciseRecord)
        }
    }


    fun getExerciseRecordByDate(date: Calendar) =
        exerciseRecordDao.getExerciseRecordByDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))


    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ExerciseRecordRepository? = null

        fun getInstance(exerciseRecordDao: ExerciseRecordDao) =
            instance ?: synchronized(this) {
                instance ?: ExerciseRecordRepository(exerciseRecordDao).also { instance = it }
            }
    }
}