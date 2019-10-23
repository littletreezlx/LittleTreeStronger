package com.example.littletreestronger.viewmodel


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.littletreestronger.common.base.BaseApplication
import com.example.littletreestronger.data.AppDatabase
import com.example.littletreestronger.data.repository.DietRecordRepository
import com.example.littletreestronger.di.dietTimeDiModule
import com.example.littletreestronger.di.exerciseDiModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

import org.mockito.Mockito


//@RunWith(RobolectricTestRunner::class)
class DietRecordViewModelTest: PowerRobTest(),KodeinAware{


    lateinit var viewModel : DietRecordViewModel
//    lateinit var repo : DietRecordRepository
    val database by lazy {
        AppDatabase.getInstance(BaseApplication.instance())
    }
    val repo by lazy {
        DietRecordRepository.getInstance(database.dietRecordDao())
    }

    val context = ApplicationProvider.getApplicationContext<Context>()

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
    fun addDietRecords() {
        val mock = Mockito.mock(DietRecordRepository::class.java)
        viewModel = DietRecordViewModel(repo)
        viewModel.addDietRecords()
        Mockito.verify(mock).insertDietRecord(Mockito.any())
    }


}