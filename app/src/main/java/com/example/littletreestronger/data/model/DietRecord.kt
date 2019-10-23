package com.example.littletreestronger.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


const val TYPE_MEAL_BREAKFAST = 0
const val TYPE_MEAL_LUNCH = 1
const val TYPE_MEAL_DINNER = 2
const val TYPE_MEAL_EXTRA = 3

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
        fun mockDietRecord(mealType: Int) = DietRecord(
            arrayOf("牛奶","鸡蛋","水果").get(Random.nextInt(3)),
            weight = Random.nextInt(200),
            mealType = mealType,
            calories = Random.nextInt(200),
            protein = Random.nextInt(20),
            fat = Random.nextInt(20),
            carbohydrate = Random.nextInt(20)
        )
    }
}




