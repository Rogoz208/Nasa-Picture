package com.example.nasapicture.domain.repos

import com.example.nasapicture.domain.entities.NasaPictureEntity

interface NasaPictureOfTheDayRepo {
    fun getPictureOfTheDay(
        onSuccess: (NasaPictureEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}