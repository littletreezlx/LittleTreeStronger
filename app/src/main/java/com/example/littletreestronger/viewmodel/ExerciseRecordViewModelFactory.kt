package com.example.littletreestronger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.littletreestronger.data.repository.ExerciseRecordRepository

class ExerciseRecordViewModelFactory(
    private val repository: ExerciseRecordRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) = ExerciseRecordViewModel(repository) as T
}