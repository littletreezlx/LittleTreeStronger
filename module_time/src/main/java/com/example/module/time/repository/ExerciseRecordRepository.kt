package com.example.module.time.repository

import com.example.common.util.runOnIoThread
import com.example.module.time.dao.ExerciseRecordDao
import com.example.module.time.data.ExerciseRecord
import java.util.*


class ExerciseRecordRepository

    private constructor(private val exerciseRecordDao: ExerciseRecordDao)
{

    fun createExerciseRecord(exerciseRecord: ExerciseRecord) {
        runOnIoThread {
            exerciseRecordDao.insertExerciseRecord(exerciseRecord)
        }
    }

    fun removeExerciseRecord(exerciseRecord: ExerciseRecord) {
        runOnIoThread {
            exerciseRecordDao.deleteExerciseRecord(exerciseRecord)
        }
    }


    fun getExerciseRecordByDate(date: Calendar) =
        exerciseRecordDao.getExerciseRecordByDate(date)


    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ExerciseRecordRepository? = null

        fun getInstance(exerciseRecordDao: ExerciseRecordDao) =
            instance ?: synchronized(this) {
                instance ?: ExerciseRecordRepository(exerciseRecordDao).also { instance = it }
            }
    }
}