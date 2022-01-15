package com.rogoz208.nasapicture.ui.screens.planets.page

import android.util.Log
import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.repos.NasaPodRepo
import com.rogoz208.nasapicture.ui.screens.planets.adapter.PlanetPageType

class PlanetPageViewModel(private val nasaPodRepo: NasaPodRepo) : ViewModel(), PlanetPageContract.ViewModel {

    override val planetPictureUrlLiveData = MutableLiveData<String>()
    override val descriptionLiveData = MutableLiveData<String>()

    override fun getData(planetPageType: PlanetPageType) {
        when (planetPageType) {
            PlanetPageType.Earth -> {
                planetPictureUrlLiveData.postValue("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Africa_and_Europe_from_a_Million_Miles_Away.png/640px-Africa_and_Europe_from_a_Million_Miles_Away.png")
                descriptionLiveData.postValue("Random picture of the Earth")
            }
            PlanetPageType.Mars -> {
                getMarsPicture()
            }
            PlanetPageType.Moon -> {
                planetPictureUrlLiveData.postValue("https://upload.wikimedia.org/wikipedia/commons/e/e1/FullMoon2010.jpg")
                descriptionLiveData.postValue("Random picture of the Moon")
            }
        }
    }

    private fun getMarsPicture(){
        nasaPodRepo.getPictureOfTheMarsAsync(onSuccess = { marsEntities ->
            planetPictureUrlLiveData.postValue(marsEntities.photos.first().imgSrc)
            descriptionLiveData.postValue(marsEntities.photos.first().camera.fullName)
        }, onError = { error ->
            Log.d("@@@", error.message.toString())
        })
    }
}