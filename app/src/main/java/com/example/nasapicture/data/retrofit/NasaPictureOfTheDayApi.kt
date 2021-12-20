package com.example.nasapicture.data.retrofit

import com.example.nasapicture.domain.entities.NasaPictureEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaPictureOfTheDayApi {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<NasaPictureEntity>
}