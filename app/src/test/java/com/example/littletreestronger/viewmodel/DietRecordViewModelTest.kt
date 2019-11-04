package com.example.littletreestronger.viewmodel


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.littletreestronger.common.base.BaseApplication
import com.example.littletreestronger.data.AppDatabase
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.model.TYPE_MEAL_BREAKFAST
import com.example.littletreestronger.data.repository.DietRecordRepository
import com.example.littletreestronger.di.dietTimeDiModule
import com.example.littletreestronger.di.exerciseDiModule
import org.junit.After
//import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.mockito.Mockito


//@RunWith(RobolectricTestRunner::class)
class DietRecordViewModelTest: PowerRobTest(),KodeinAware{
//    class DietRecordViewModelTest: KodeinAware{


        lateinit var viewModel : DietRecordViewModel
//    lateinit var repo : DietRecordRepository
    val database by lazy {
        AppDatabase.getInstance(BaseApplication.instance())
    }
    val repo by lazy {
        DietRecordRepository.getInstance(database.dietRecordDao())
    }
//    val context = ApplicationProvider.getApplicationContext<Context>()

    private val viewModel2314: DietRecordViewModel by instance()

    override val kodein = Kodein{
//        extend(parentKodein, copy = Copy.All)
        import(exerciseDiModule)
        import(dietTimeDiModule)
//        bind<MainActivity>() with instance(this)
    }


    @Before
    fun setUp() {
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        repo = DietRecordRepository.getInstance(context)
//        model = ViewModelProvider(context as MainActivity, DietRecordViewModelFactory(context)).get(DietRecordViewModel::class.java)
    }

    @After
    fun tearDown() {
    }


    @Test
    fun getConfig() {
    }

    @Test
    fun getDietRecords() {
//        val mock = Mockito.mock(DietRecordRepository::class.java)
//        viewModel.addDietRecords()
//
//        val i = true
//        assertThat(i).isFalse()
    }

    @Test
    fun getBreakfastDietRecords() {
    }

    @Test
    fun getLunchfastDietRecords() {
    }

    @Test
    fun addDietRecords_vm() {
//        val mock = Mockito.mock(DietRecordRepository::class.java)
//        viewModel = DietRecordViewModel(repo)
//        viewModel.addDietRecords()
//        Mockito.verify(mock).insertDietRecord(Mockito.any())

        val testDietRecord = DietRecord(
            "牛奶",
            weight = 200,
            mealType = TYPE_MEAL_BREAKFAST,
            calories = 200,
            protein = 20,
            fat = 20,
            carbohydrate = 20
        )
        val repo = Mockito.mock(DietRecordRepository::class.java)
        val vm = DietRecordViewModel(repo)
        val oldSum = vm.calorySum.value
        vm.addDietRecords(testDietRecord)

        assertThat(vm.breakfastRecords.value?.last(), `is`(testDietRecord) )
        assertThat(vm.calorySum.value, `is`(oldSum?.plus(testDietRecord.calories)))
    }





}