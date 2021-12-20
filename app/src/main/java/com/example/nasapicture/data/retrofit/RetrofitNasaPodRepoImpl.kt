package com.example.nasapicture.data.retrofit

import com.example.nasapicture.BuildConfig
import com.example.nasapicture.domain.entities.NasaPodEntity
import com.example.nasapicture.domain.repos.NasaPodRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitNasaPodRepoImpl(private val api: NasaPodApi) :
    NasaPodRepo {

    override fun getPictureOfTheDay(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val apiKey = BuildConfig.NASA_API_KEY
        api.getPictureOfTheDay(apiKey).enqueue(object : Callback<NasaPodEntity> {
            override fun onResponse(
                call: Call<NasaPodEntity>,
                response: Response<NasaPodEntity>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body() ?: throw IllegalStateException("null result"))
                } else {
                    onError(Throwable("unknown error"))
                }
            }

            override fun onFailure(call: Call<NasaPodEntity>, t: Throwable) {
                onError(t)
            }
        })
    }
}