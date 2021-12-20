package com.example.nasapicture.ui.screens.picture

import androidx.lifecycle.LiveData
import com.example.nasapicture.domain.entities.NasaPictureEntity

class NasaPictureContract {

    interface ViewModel{
        val nasaPictureLiveData: LiveData<NasaPictureEntity>

        fun getData()
    }
}