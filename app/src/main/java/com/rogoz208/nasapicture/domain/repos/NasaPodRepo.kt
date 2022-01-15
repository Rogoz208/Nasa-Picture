package com.rogoz208.nasapicture.domain.repos

import com.rogoz208.nasapicture.domain.entities.*

interface NasaPodRepo {

    fun getPictureOfTheDaySync(): NasaPodEntity

    fun getPictureOfTheDayAsync(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun getPictureOfTheMarsSync(): MarsEntity

    fun getPictureOfTheMarsAsync(
        onSuccess: (MarsEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}