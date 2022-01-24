package com.rogoz208.nasapicture.ui.screens.picture

import android.util.Log
import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity
import com.rogoz208.nasapicture.domain.repos.NasaRepository

class NasaPodViewModel(private val nasaRepository: NasaRepository) : ViewModel(), NasaPodContract.ViewModel {

    override val nasaPodLiveData = MutableLiveData<NasaPodEntity>()
    override val isPodLoadedLiveData = MutableLiveData(false)

    override fun getData() {
        isPodLoadedLiveData.postValue(false)

        nasaRepository.getPictureOfTheDayAsync(onSuccess = { nasaPictureEntity ->
            nasaPodLiveData.postValue(nasaPictureEntity)
            isPodLoadedLiveData.postValue(true)
        }, onError = { error ->
            Log.d("@@@", error.message.toString())
        })
    }
}