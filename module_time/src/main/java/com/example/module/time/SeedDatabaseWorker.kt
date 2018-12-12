package com.example.module.time



//class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters)
//    : Worker(context, workerParams)
//{
//    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }
//
//    override fun doWork(): Worker.resu {
//        val plantType = object : TypeToken<List<Plant>>() {}.type
//        var jsonReader: JsonReader? = null
//
//        return try {
//            val inputStream = applicationContext.assets.open(PLANT_DATA_FILENAME)
//            jsonReader = JsonReader(inputStream.reader())
//            val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
//            val database = AppDatabase.getInstance(applicationContext)
//            database.plantDao().insertAll(plantList)
//            Worker.Result.SUCCESS
//        } catch (ex: Exception) {
//            Log.e(TAG, "Error seeding database", ex)
//            Worker.Result.FAILURE
//        } finally {
//            jsonReader?.close()
//        }
//    }
//}