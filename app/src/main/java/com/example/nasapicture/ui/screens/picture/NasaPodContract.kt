package com.example.nasapicture.ui.screens.picture

import androidx.lifecycle.LiveData
import com.example.nasapicture.domain.entities.NasaPodEntity

class NasaPodContract {

    interface ViewModel{
        val nasaPodLiveData: LiveData<NasaPodEntity>

        fun getData()
    }
}