package com.example.nasapicture.data.retrofit

import com.example.nasapicture.domain.entities.NasaPodEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaPodApi {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<NasaPodEntity>
}