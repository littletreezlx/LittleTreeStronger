package com.example.littletreestronger.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.littletreestronger.data.ExerciseActionEnum
import java.util.*
import kotlin.random.Random


@Entity(
    tableName = "exercise_record"
//    foreignKeys = [ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plant_id"])],
//    indices = [Index("exercise_title")]
)
data class ExerciseRecord(

    @ColumnInfo(name = "exercise_title")
    val title: String,


    @ColumnInfo(name = "exercise_weight")
    val weight: Int,


    @ColumnInfo(name = "exercise_times")
    val times: Int,


    @ColumnInfo(name = "exercise_date")
    val date: Calendar = Calendar.getInstance(),


    @ColumnInfo(name = "exercise_year")
    val year: Int = date.get(Calendar.YEAR),


    @ColumnInfo(name = "exercise_month")
    val month: Int = date.get(Calendar.MONTH),


    @ColumnInfo(name = "exercise_day")
    val day: Int = date.get(Calendar.DAY_OF_MONTH)



) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var exerciseRecordId: Long = 0



    companion object {
        fun mockExerciseRecord() = ExerciseRecord(
            ExerciseActionEnum.values().run {
                get(Random.nextInt(this.size))
            }.chineseName,
            Random.nextInt(100),
            Random.nextInt(12)
        )
    }
}


