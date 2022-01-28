package com.rogoz208.nasapicture.domain.repos

import com.rogoz208.nasapicture.domain.entities.NasaPodEntity

interface NasaRepository {

    fun getPictureOfTheDayAsync(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}