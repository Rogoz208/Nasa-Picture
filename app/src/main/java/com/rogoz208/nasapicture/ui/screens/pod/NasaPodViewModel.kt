package com.rogoz208.nasapicture.ui.screens.pod

import android.util.Log
import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity
import com.rogoz208.nasapicture.domain.repos.NasaPodRepo

class NasaPodViewModel(private val nasaPodRepo: NasaPodRepo) : ViewModel(), NasaPodContract.ViewModel {

    override val nasaPodLiveData = MutableLiveData<NasaPodEntity>()
    override val isPodLoadedLiveData = MutableLiveData(false)

    override fun getData() {
        isPodLoadedLiveData.postValue(false)
        nasaPodRepo.getPictureOfTheDayAsync(
            onSuccess = { nasaPictureEntity ->
            nasaPodLiveData.postValue(nasaPictureEntity)
            isPodLoadedLiveData.postValue(true)
        },
            onError = { error ->
            Log.d("@@@", error.message.toString())
        })
    }
}