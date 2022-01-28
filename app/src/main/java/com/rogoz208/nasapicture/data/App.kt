package com.rogoz208.nasapicture.data

import android.app.Application
import android.content.Context
import com.rogoz208.nasapicture.data.retrofit.*
import com.rogoz208.nasapicture.domain.repos.NasaRepository

class App : Application() {

    val nasaRepository: NasaRepository by lazy { RetrofitNasaRepositoryImpl(NasaPodRetrofitLoader().api) }
}

val Context.app: App
    get() = applicationContext as App