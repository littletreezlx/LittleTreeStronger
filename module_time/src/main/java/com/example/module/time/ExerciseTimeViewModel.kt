package com.example.module.time

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExerciseTimeViewModel : ViewModel(){


    private lateinit var users: MutableLiveData<ArrayList<ExerciseRecord>>

    fun getExerciseRecords(): LiveData<ArrayList<ExerciseRecord>> {
        if (!::users.isInitialized) {
            users = MutableLiveData()
            loadUsers()
        }
        return users
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }

}