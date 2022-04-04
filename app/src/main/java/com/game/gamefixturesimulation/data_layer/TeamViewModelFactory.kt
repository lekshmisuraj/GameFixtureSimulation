package com.game.gamefixturesimulation.data_layer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TeamViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TeamViewModel::class.java)) {
            return TeamViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}