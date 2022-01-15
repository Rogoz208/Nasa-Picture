package com.rogoz208.nasapicture.ui.screens.planets.page

import androidx.lifecycle.LiveData
import com.rogoz208.nasapicture.ui.screens.planets.adapter.PlanetPageType

class PlanetPageContract {

    interface ViewModel{

        val planetPictureUrlLiveData: LiveData<String>
        val descriptionLiveData: LiveData<String>

        fun getData(planetPageType: PlanetPageType)
    }
}