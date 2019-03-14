package com.example.module.main.kodein

import androidx.lifecycle.ViewModelProviders
import com.example.common.base.BaseApplication
import com.example.module.main.data.AppDatabase
import com.example.module.main.data.dao.ExerciseRecordDao
import com.example.module.main.data.repository.ExerciseRecordRepository
import com.example.module.main.ui.MainActivity
import com.example.module.main.viewmodel.ExerciseTimeViewModel
import com.example.module.main.viewmodel.ExerciseTimeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton


val EXERCISE_TIME_DI_MODULE = "exerciseTimeDiModule"

val exerciseTimeDiModule = Kodein.Module(EXERCISE_TIME_DI_MODULE) {




    bind<AppDatabase>() with singleton {
        AppDatabase.getInstance(BaseApplication.instance())
    }

    bind<ExerciseRecordDao>() with singleton {

        instance<AppDatabase>().exerciseRecordDao()
//        (instance() as AppDatabase).exerciseRecordDao()
    }


    bind<ExerciseRecordRepository>() with singleton {
        ExerciseRecordRepository.getInstance(instance())
    }


    bind<ExerciseTimeViewModel>() with scoped(ActivityRetainedScope.MultiItem).singleton {
        ViewModelProviders
            .of(context as MainActivity, ExerciseTimeViewModelFactory(instance()))
            .get(ExerciseTimeViewModel::class.java)
    }


}
