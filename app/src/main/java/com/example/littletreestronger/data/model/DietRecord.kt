package com.example.littletreestronger.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.random.Random


@Entity(
    tableName = "diet_record"
//    foreignKeys = [ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plant_id"])],
//    indices = [Index("exercise_title")]
)
data class DietRecord(

    @ColumnInfo(name = "diet_name")
    val name: String,

    @ColumnInfo(name = "diet_weight")
    val weight: Int,

    @ColumnInfo(name = "meal_type")
    val mealType: Int,

    @ColumnInfo(name = "diet_calories")
    val calories: Int,

    @ColumnInfo(name = "diet_protein")
    val protein: Int,

    @ColumnInfo(name = "diet_fat")
    val fat: Int,

    @ColumnInfo(name = "diet_carbohydrate")
    val carbohydrate: Int,

    @ColumnInfo(name = "diet_date")
    val date: Calendar = Calendar.getInstance(),

    @ColumnInfo(name = "diet_year")
    val year: Int = date.get(Calendar.YEAR),


    @ColumnInfo(name = "diet_month")
    val month: Int = date.get(Calendar.MONTH),


    @ColumnInfo(name = "diet_day")
    val day: Int = date.get(Calendar.DAY_OF_MONTH)

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0



    companion object {
        val TYPE_MEAL_BREAKFAST = 0
        val TYPE_MEAL_LUNCH = 1
        val TYPE_MEAL_DINNER = 2
        val TYPE_MEAL_EXTRA = 2

        fun mockDietRecord() = DietRecord("牛奶",
            Random.nextInt(200),
            TYPE_MEAL_BREAKFAST,
            Random.nextInt(200),
            Random.nextInt(20),
            Random.nextInt(20),
            Random.nextInt(20)
        )

        fun mockDietRecord2() = DietRecord("鸡蛋",
            Random.nextInt(200),
            TYPE_MEAL_LUNCH,
            Random.nextInt(200),
            Random.nextInt(20),
            Random.nextInt(20),
            Random.nextInt(20)
        )
    }
}



