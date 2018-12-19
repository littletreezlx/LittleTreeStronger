package com.example.module.time.di

import androidx.lifecycle.ViewModelProviders
import com.example.module.time.AppDatabase
import com.example.module.time.repository.ExerciseRecordRepository
import com.example.module.time.ui.ExerciseTimeActivity
import com.example.module.time.viewmodel.ExerciseTimeViewModel
import com.example.module.time.viewmodel.ExerciseTimeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton


val EXERCISE_TIME_DI_MODULE = "exerciseTimeDiModule"

val exerciseTimeDiModule = Kodein.Module(EXERCISE_TIME_DI_MODULE) {


    bind<ExerciseTimeViewModel>() with scoped(ActivityRetainedScope).singleton {
        ViewModelProviders
            .of(context as ExerciseTimeActivity, ExerciseTimeViewModelFactory(instance()))
            .get(ExerciseTimeViewModel::class.java)
    }



    bind<AppDatabase>() with scoped(ActivityRetainedScope).singleton {
        AppDatabase.getInstance(context)
    }


    bind<ExerciseRecordRepository>() with scoped(ActivityRetainedScope).singleton {
        ExerciseRecordRepository.getInstance((instance() as AppDatabase).exerciseRecordDao())
    }




}
