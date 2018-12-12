package com.example.module.time

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module.time.data.ExerciseRecord
import com.example.module.time.repository.ExerciseRecordRepository

class ExerciseTimeViewModelFactory(
    private val repository: ExerciseRecordRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = ExerciseTimeViewModel(repository) as T
}