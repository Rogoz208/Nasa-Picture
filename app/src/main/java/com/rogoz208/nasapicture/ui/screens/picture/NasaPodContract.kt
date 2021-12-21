package com.rogoz208.nasapicture.ui.screens.picture

import androidx.lifecycle.LiveData
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity

class NasaPodContract {

    interface ViewModel{
        val nasaPodLiveData: LiveData<NasaPodEntity>

        fun getData()
    }
}