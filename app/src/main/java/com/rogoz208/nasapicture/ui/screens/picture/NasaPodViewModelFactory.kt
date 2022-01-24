package com.rogoz208.nasapicture.ui.screens.picture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rogoz208.nasapicture.domain.repos.NasaRepository

class NasaPodViewModelFactory(private val nasaRepository: NasaRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NasaPodViewModel(nasaRepository) as T
    }
}