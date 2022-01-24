package com.rogoz208.nasapicture.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NASA_BASE_URL = "https://api.nasa.gov/"

class NasaPodRetrofitLoader {

    private val retrofit = Retrofit.Builder()
        .baseUrl(NASA_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var api: NasaPodApi = retrofit.create(NasaPodApi::class.java)
}