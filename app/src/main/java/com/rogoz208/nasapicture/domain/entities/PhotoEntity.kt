package com.rogoz208.nasapicture.domain.entities

import com.google.gson.annotations.SerializedName

data class PhotoEntity(
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("camera")
    val cameraEntity: CameraEntity
)