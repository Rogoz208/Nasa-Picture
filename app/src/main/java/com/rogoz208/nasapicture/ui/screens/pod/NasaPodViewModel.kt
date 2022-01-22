package com.rogoz208.nasapicture.ui.screens.pod

import android.text.Spanned
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import androidx.core.text.toSpannable
import androidx.lifecycle.*
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity
import com.rogoz208.nasapicture.domain.repos.NasaPodRepo

class NasaPodViewModel(private val nasaPodRepo: NasaPodRepo) : ViewModel(), NasaPodContract.ViewModel {

    override val nasaPodLiveData = MutableLiveData<NasaPodEntity>()
    override val isPodLoadedLiveData = MutableLiveData(false)
    override val spannableTextLiveData = MutableLiveData<CharSequence>()
    override val messageTextLiveData = MutableLiveData<String>()

    override fun getData() {
        isPodLoadedLiveData.postValue(false)
        nasaPodRepo.getPictureOfTheDayAsync(
            onSuccess = { nasaPictureEntity ->
            nasaPodLiveData.postValue(nasaPictureEntity)
            isPodLoadedLiveData.postValue(true)
            createSpannableText(nasaPictureEntity.copyright)

        },
            onError = { error ->
            Log.d("@@@", error.message.toString())
        })
    }

    private fun createSpannableText(textForSpan: String) {
        val copyrightString = "Copyright: $textForSpan"

        val clickableSpan = object : ClickableSpan() {

            override fun onClick(widget: View) {
                messageTextLiveData.postValue(copyrightString)
            }

        }

        val spannable = copyrightString.toSpannable()
        val endOfSpan = copyrightString.length

        spannable.setSpan(clickableSpan, 11, endOfSpan, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableTextLiveData.postValue(spannable)
    }
}