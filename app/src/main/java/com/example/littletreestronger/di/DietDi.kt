package com.example.littletreestronger.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.littletreestronger.data.AppDatabase
import com.example.littletreestronger.data.dao.DietRecordDao
import com.example.littletreestronger.data.repository.DietRecordRepository
import com.example.littletreestronger.common.base.MainActivity
import com.example.littletreestronger.viewmodel.DietRecordViewModel
import com.example.littletreestronger.viewmodel.DietRecordViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton



val DIET_TIME_DI_MODULE = "DietTimeDiModule"

val dietTimeDiModule = Kodein.Module(DIET_TIME_DI_MODULE) {


    bind<DietRecordDao>() with singleton {
        instance<AppDatabase>().dietRecordDao()
    }


    bind<DietRecordRepository>() with singleton {
        DietRecordRepository.getInstance(instance())
    }


    bind<DietRecordViewModel>() with scoped(ActivityRetainedScope.MultiItem).singleton {
//        ViewModelProviders
//            .of(context as MainActivity, DietRecordViewModelFactory(instance()))
//            .get(DietRecordViewModel::class.java)
        ViewModelProvider(context as MainActivity, DietRecordViewModelFactory(instance())).get(DietRecordViewModel::class.java)
    }


}
