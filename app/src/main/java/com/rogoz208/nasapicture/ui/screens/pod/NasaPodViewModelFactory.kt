package com.rogoz208.nasapicture.ui.screens.pod

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rogoz208.nasapicture.domain.repos.NasaPodRepo

class NasaPodViewModelFactory(private val nasaPodRepo: NasaPodRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NasaPodViewModel(nasaPodRepo) as T
    }
}