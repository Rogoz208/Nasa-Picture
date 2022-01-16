package com.rogoz208.nasapicture.ui.screens.planets.page

import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.repos.NasaPodRepo

class PlanetPageViewModelFactory(private val nasaPodRepo: NasaPodRepo) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlanetPageViewModel(nasaPodRepo) as T
    }
}