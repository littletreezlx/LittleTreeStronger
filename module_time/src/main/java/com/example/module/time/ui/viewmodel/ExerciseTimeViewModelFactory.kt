package com.example.module.time.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module.time.data.repository.ExerciseRecordRepository

class ExerciseTimeViewModelFactory(
    private val repository: ExerciseRecordRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) = ExerciseTimeViewModel(repository) as T
}