package com.example.nasapicture.domain.entities

import com.google.gson.annotations.SerializedName

data class NasaPodEntity(
    @SerializedName("url")
    val url: String,
    @SerializedName("explanation")
    val explanation: String
)