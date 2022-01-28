package com.rogoz208.nasapicture.ui.screens.picture

import androidx.lifecycle.LiveData
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity

interface NasaPodContract {

    interface ViewModel {

        val nasaPodLiveData: LiveData<NasaPodEntity>
        val isPodLoadedLiveData: LiveData<Boolean>

        fun getData()
    }
}