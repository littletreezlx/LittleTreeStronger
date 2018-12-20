package com.example.module.time.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(
    tableName = "exercise_record"
//    foreignKeys = [ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plant_id"])],
//    indices = [Index("exercise_title")]
)
data class ExerciseRecord(

    @ColumnInfo(name = "exercise_title")
    val title: String,

    @ColumnInfo(name = "exercise_times")
    val times: Int,

    @ColumnInfo(name = "exercise_date")
    val date: Calendar = Calendar.getInstance()

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var exerciseRecordId: Long = 0
}