package com.example.littletreestronger.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.littletreestronger.constants.DATABASE_NAME
import com.example.littletreestronger.constants.ExerciseActionEnum
import com.example.littletreestronger.data.dao.DietRecordDao
import com.example.littletreestronger.data.dao.ExerciseRecordDao
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.model.ExerciseRecord
import com.example.littletreestronger.util.runOnIoThread
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import timber.log.Timber
import kotlin.random.Random


@Database(entities = [ExerciseRecord::class, DietRecord::class], version = 2, exportSchema = false)
@TypeConverters(CalenderConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exerciseRecordDao(): ExerciseRecordDao

    abstract fun dietRecordDao(): DietRecordDao


    companion object {
        @Volatile private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }


        private fun buildDatabase(context: Context): AppDatabase {
//            val log = AnkoLogger(AppDatabase::class.java)
//            log.debug("build database")
//
            Timber.d("build database")

            return Room
                .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    //第一次创建数据库时调用，但是在创建所有表之后调用的
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        runOnIoThread {
                            instance?.let {
                                val exerciseRecordDao = it.exerciseRecordDao()

                                Timber.d("first build database")
                                exerciseRecordDao.insertExerciseRecord(ExerciseRecord.mockExerciseRecord())
                                exerciseRecordDao.insertExerciseRecord(ExerciseRecord.mockExerciseRecord())

                            }
                        }
                    }

                    //当数据库被打开时调用
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        Timber.d("prepare database")

                        runOnIoThread {
                            instance?.let {
                                val exerciseRecordDao = it.exerciseRecordDao()
                                exerciseRecordDao.deleteAll()
                                exerciseRecordDao.insertExerciseRecord(ExerciseRecord.mockExerciseRecord())
                                exerciseRecordDao.insertExerciseRecord(ExerciseRecord.mockExerciseRecord())

                                val dietRecordDao = it.dietRecordDao()
                                dietRecordDao.deleteAll()
                                dietRecordDao.insertDietRecord(DietRecord.mockDietRecord())
                                dietRecordDao.insertDietRecord(DietRecord.mockDietRecord2())

                            }
                        }
                    }

                })
                .build()
        }
    }





//    private class PopulateDbAsync internal constructor(db: AppDatabase) : AsyncTask<Void, Void, Void>() {
//        private val dao: ExerciseRecordDao = db.exerciseRecordDao()
//
//        override fun doInBackground(vararg params: Void): Void? {
//
//            val log = AnkoLogger(this.javaClass)
//            log.debug("prepare database")
//            //dangerous!!!
//            dao.deleteAll()
////            val record = ExerciseRecord(ExerciseActionEnum.YINGLA.chineseName, Random.nextInt(10))
////            dao.insertExerciseRecord(record)
//                dao.insertExerciseRecord(
//                    ExerciseRecord(
//                        ExerciseActionEnum.values().run {
//                            this.get(Random.nextInt(this.size))
//                        }.chineseName,
//                        Random.nextInt(100),
//                        Random.nextInt(12)
//                    )
//                )
//            return null
//        }
//    }
}
