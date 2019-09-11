package com.example.littletreestronger.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.model.ExerciseRecord
import java.util.*


@Dao
interface DietRecordDao {

    @Insert
    fun insertDietRecord(dietRecord: DietRecord): Long

    @Delete
    fun deleteDietRecord(dietRecord: DietRecord)

    @Update
    fun updateDietRecord(dietRecord: DietRecord)

    
    @Query("SELECT * FROM diet_record WHERE id = :dietRecordId")
    fun getDietRecordById(dietRecordId: Long): LiveData<DietRecord>
    
    
//    @Query("SELECT * FROM diet_record WHERE diet_date = :date")
//    fun getdietRecordByDate(date: Calendar): DataSource.Factory<Int, DietRecord>

    @Query("SELECT * FROM diet_record WHERE diet_year = :year And  diet_month = :month And  diet_day = :day ")
    fun getDietRecordByDate(year: Int, month: Int, day: Int): DataSource.Factory<Int, DietRecord>
    
    
    @Query("DELETE FROM diet_record")
    fun deleteAll()
}