package com.example.nasapicture.ui.screens.picture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nasapicture.domain.repos.NasaPodRepo

class NasaPodViewModelFactory(private val nasaPodRepo: NasaPodRepo):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NasaPodViewModel(nasaPodRepo) as T
    }
}