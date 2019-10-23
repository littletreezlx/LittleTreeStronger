package com.example.littletreestronger.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.littletreestronger.data.model.DietRecord


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

//    @Query("SELECT * FROM diet_record WHERE diet_year = :year And  diet_month = :month And  diet_day = :day  And  meal_type = :mealtype")
//    fun getBreakfastDietRecordByDate(year: Int, month: Int, day: Int, mealtype : Int = DietRecord.TYPE_MEAL_BREAKFAST): DataSource.Factory<Int, DietRecord>
//
//    @Query("SELECT * FROM diet_record WHERE diet_year = :year And  diet_month = :month And  diet_day = :day  And  meal_type = :mealtype")
//    fun getLunchDietRecordByDate(year: Int, month: Int, day: Int, mealtype : Int = DietRecord.TYPE_MEAL_LUNCH): DataSource.Factory<Int, DietRecord>
//
//    @Query("SELECT * FROM diet_record WHERE diet_year = :year And  diet_month = :month And  diet_day = :day  And  meal_type = :mealtype")
//    fun getDinnerDietRecordByDate(year: Int, month: Int, day: Int, mealtype : Int = DietRecord.TYPE_MEAL_DINNER): DataSource.Factory<Int, DietRecord>

    @Query("SELECT * FROM diet_record WHERE diet_year = :year And  diet_month = :month And  diet_day = :day  And  meal_type = :mealtype")
    fun getDietRecordByDateAndMealType(year: Int, month: Int, day: Int, mealtype : Int): DataSource.Factory<Int, DietRecord>

    @Query("DELETE FROM diet_record")
    fun deleteAll()
}