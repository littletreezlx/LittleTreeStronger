package com.example.littletreestronger.data.repository

import com.example.littletreestronger.common.util.runOnIoThread
import com.example.littletreestronger.data.dao.DietRecordDao
import com.example.littletreestronger.data.model.DietRecord
import java.util.*


class DietRecordRepository

    private constructor(private val DietRecordDao: DietRecordDao)
{

    fun insertDietRecord(DietRecord: DietRecord) {
        runOnIoThread {
            DietRecordDao.insertDietRecord(DietRecord)
        }
    }

    fun deleteDietRecord(DietRecord: DietRecord) {
        runOnIoThread {
            DietRecordDao.deleteDietRecord(DietRecord)
        }
    }


//    fun getDietRecordByDate(date: Calendar) = DietRecordDao.getDietRecordByDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
//
//    fun getBreakfastDietRecordByDate(date: Calendar) = DietRecordDao.getBreakfastDietRecordByDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
//
//    fun getLunchDietRecordByDate(date: Calendar) = DietRecordDao.getLunchDietRecordByDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
//
//    fun getDinnerDietRecordByDate(date: Calendar) = DietRecordDao.getDinnerDietRecordByDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
//
    fun getDietRecordByDateAndMealType(date: Calendar, mealType: Int) = DietRecordDao.getDietRecordByDateAndMealType(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH), mealType)


    companion object {
        @Volatile private var instance: DietRecordRepository? = null

        fun getInstance(DietRecordDao: DietRecordDao) =
            instance ?: synchronized(this) {
                instance ?: DietRecordRepository(DietRecordDao).also { instance = it }
            }
    }
}