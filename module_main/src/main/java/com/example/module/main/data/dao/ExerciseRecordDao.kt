package com.example.module.main.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.module.main.data.model.ExerciseRecord

@Dao
interface ExerciseRecordDao {

    @Insert
    fun insertExerciseRecord(exerciseRecord: ExerciseRecord): Long

    @Delete
    fun deleteExerciseRecord(exerciseRecord: ExerciseRecord)

    @Update
    fun updateExerciseRecord(exerciseRecord: ExerciseRecord)



    @Query("SELECT * FROM exercise_record WHERE id = :exerciseRecordId")
    fun getExerciseRecordById(exerciseRecordId: Long): LiveData<ExerciseRecord>


    //NO!
//    @Query("SELECT * FROM exercise_record WHERE exercise_date = :exerciseRecordDate ")
//    fun getExerciseRecordByDate(exerciseRecordDate: Calendar): LiveData<List<ExerciseRecord>>


    @Query("SELECT * FROM exercise_record WHERE exercise_year = :year And  exercise_month = :month And  exercise_day = :day ")
    fun getExerciseRecordByDate(year: Int, month: Int, day: Int): LiveData<List<ExerciseRecord>>




//    @Insert
//    fun insertAll(???)

    @Query("DELETE FROM exercise_record")
    fun deleteAll()


//
//    /**
//     * This query will tell Room to query both the [Plant] and [GardenPlanting] tables and handle
//     * the object mapping.
//     */
//    @Transaction
//    @Query("SELECT * FROM plants")
//    fun getPlantAndGardenPlantings(): LiveData<List<PlantAndGardenPlantings>>
//
//    @Insert
//    fun insertGardenPlanting(gardenPlanting: GardenPlanting): Long
//
//    @Delete
//    fun deleteGardenPlanting(gardenPlanting: GardenPlanting)
}