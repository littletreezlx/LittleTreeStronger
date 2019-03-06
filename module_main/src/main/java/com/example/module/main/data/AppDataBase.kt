package com.example.module.main.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.common.DATABASE_NAME
import com.example.module.main.constants.ExerciseActionEnum
import com.example.module.main.data.dao.ExerciseRecordDao
import com.example.module.main.data.model.ExerciseRecord
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import kotlin.random.Random


@Database(entities = [ExerciseRecord::class], version = 1, exportSchema = false)
@TypeConverters(CalenderConverters::class)
abstract class AppDatabase : RoomDatabase() {



    abstract fun exerciseRecordDao(): ExerciseRecordDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }



        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            val log = AnkoLogger(this.javaClass)
            log.debug("build database")


            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
//                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
//                        WorkManager.getInstance().enqueue(request)



                        PopulateDbAsync(instance!!)
                            .execute()

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


            val log = AnkoLogger(this.javaClass)
            log.debug("prepare database")


            //dangerous!!!
            dao.deleteAll()

//            val record = ExerciseRecord(ExerciseActionEnum.YINGLA.chineseName, Random.nextInt(10))
//            dao.insertExerciseRecord(record)


                dao.insertExerciseRecord(
                    ExerciseRecord(
                        ExerciseActionEnum.values().run {
                            this.get(Random.nextInt(this.size))
                        }.chineseName,
                        Random.nextInt(100),
                        Random.nextInt(12)
                    )
                )

            return null
        }
    }


}

//
//fun ExerciseActionEnum.getRandomName() = ExerciseActionEnum.values().apply {
//    get(Random.nextInt(size))
//}