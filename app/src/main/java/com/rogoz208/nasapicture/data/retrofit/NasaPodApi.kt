package com.rogoz208.nasapicture.data.retrofit

import com.rogoz208.nasapicture.domain.entities.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaPodApi {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<NasaPodEntity>

    @GET("mars-photos/api/v1/rovers/curiosity/photos?earth_date=2021-12-7")
    fun getMars(@Query("api_key") apiKey: String): Call<MarsEntity>
}