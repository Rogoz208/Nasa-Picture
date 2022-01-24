package com.rogoz208.nasapicture.domain.entities

import com.google.gson.annotations.SerializedName

data class CameraEntity(
    @SerializedName("full_name")
    val fullName: String
)