package com.rogoz208.nasapicture.domain.entities

import com.google.gson.annotations.SerializedName

data class MarsEntity(
    @SerializedName("photos")
    val photos: List<PhotoEntity>,
)

data class PhotoEntity(
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("camera")
    val camera: Camera
)

data class Camera(
    @SerializedName("full_name")
    val fullName: String
)