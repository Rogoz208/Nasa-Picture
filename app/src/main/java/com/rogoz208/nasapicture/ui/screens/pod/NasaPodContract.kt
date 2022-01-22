package com.rogoz208.nasapicture.ui.screens.pod

import androidx.lifecycle.LiveData
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity

class NasaPodContract {

    interface ViewModel {

        val nasaPodLiveData: LiveData<NasaPodEntity>
        val isPodLoadedLiveData: LiveData<Boolean>
        val spannableTextLiveData: LiveData<CharSequence>
        val messageTextLiveData: LiveData<String>

        fun getData()
    }
}