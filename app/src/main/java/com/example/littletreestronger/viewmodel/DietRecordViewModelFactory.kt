package com.example.littletreestronger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.littletreestronger.data.repository.DietRecordRepository
import com.example.littletreestronger.data.repository.ExerciseRecordRepository

class DietRecordViewModelFactory(
    private val repository: DietRecordRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) = DietRecordViewModel(repository) as T
}