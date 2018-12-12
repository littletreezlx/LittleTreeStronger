package com.example.module.time

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.common.DATABASE_NAME
import com.example.module.time.dao.ExerciseRecordDao
import com.example.module.time.data.ExerciseRecord
import kotlin.random.Random


@Database(entities = [ExerciseRecord::class], version = 1, exportSchema = false)
@TypeConverters(CalenderConverters::class)
abstract class AppDatabase : RoomDatabase() {


    abstract fun exerciseRecordDao(): ExerciseRecordDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
//                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
//                        WorkManager.getInstance().enqueue(request)



                        PopulateDbAsync(instance!!).execute()
                    }
                })
                .build()
        }
    }


    private class PopulateDbAsync internal constructor(db: AppDatabase) : AsyncTask<Void, Void, Void>() {

        private val dao: ExerciseRecordDao = db.exerciseRecordDao()

//        init {
//            dao = db.exerciseRecordDao()
//        }

        override fun doInBackground(vararg params: Void): Void? {


            //dangerous!!!
            dao.deleteAll()

            val record = ExerciseRecord(ExerciseActionEnum.YINGLA.chineseName, Random.nextInt())
            dao.insertExerciseRecord(record)

            val record1 = ExerciseRecord(ExerciseActionEnum.YINGLA.chineseName, Random.nextInt())
            dao.insertExerciseRecord(record1)

            return null
        }
    }
}