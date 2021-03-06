package com.rogoz208.nasapicture.data.retrofit

import com.rogoz208.nasapicture.BuildConfig
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity
import com.rogoz208.nasapicture.domain.repos.NasaRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitNasaRepositoryImpl(private val api: NasaPodApi) : NasaRepository {

    private val apiKey by lazy {
        if (BuildConfig.NASA_API_KEY.isNotBlank()) {
            BuildConfig.NASA_API_KEY
        } else {
            throw IllegalStateException("you need API key")
        }
    }

    override fun getPictureOfTheDayAsync(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        api.getPictureOfTheDay(apiKey).enqueue(object : Callback<NasaPodEntity> {
            override fun onResponse(call: Call<NasaPodEntity>, response: Response<NasaPodEntity>) {
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