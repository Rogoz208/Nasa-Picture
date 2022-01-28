package com.rogoz208.nasapicture.data.retrofit

import com.rogoz208.nasapicture.domain.entities.NasaPodEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaPodApi {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<NasaPodEntity>
}