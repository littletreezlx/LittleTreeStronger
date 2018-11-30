package com.example.module.time.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.module.time.data.ExerciseRecord
import java.util.*
import kotlin.collections.ArrayList

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


    @Query("SELECT * FROM exercise_record WHERE exercise_date = :exerciseRecordDate")
    fun getExerciseRecordByDate(exerciseRecordDate: Calendar): LiveData<ArrayList<ExerciseRecord>>




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