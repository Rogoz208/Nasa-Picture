package com.example.nasapicture.domain.repos

import com.example.nasapicture.domain.entities.NasaPodEntity

interface NasaPodRepo {
    fun getPictureOfTheDay(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}