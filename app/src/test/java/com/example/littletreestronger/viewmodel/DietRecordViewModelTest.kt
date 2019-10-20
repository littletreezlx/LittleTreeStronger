package com.example.littletreestronger.viewmodel


import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.littletreestronger.common.base.BaseApplication
import com.example.littletreestronger.common.base.MainActivity
import com.example.littletreestronger.data.AppDatabase
import com.example.littletreestronger.data.dao.DietRecordDao
import com.example.littletreestronger.data.dao.ExerciseRecordDao
import com.example.littletreestronger.data.model.DietRecord
import com.example.littletreestronger.data.repository.DietRecordRepository
import com.example.littletreestronger.data.repository.ExerciseRecordRepository
import com.example.littletreestronger.di.dietTimeDiModule
import com.example.littletreestronger.di.exerciseDiModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.scoped
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import kotlin.random.Random

@RunWith(RobolectricTestRunner::class)
class DietRecordViewModelTest: KodeinAware{


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
        viewModel = ViewModelProvider(context as MainActivity, DietRecordViewModelFactory(repo)).get(DietRecordViewModel::class.java)
        viewModel.addDietRecords()
        Mockito.verify(mock).insertDietRecord(DietRecord.mockDietRecord())
    }


}