package com.rogoz208.nasapicture.domain.entities

import com.google.gson.annotations.SerializedName

data class MarsEntity(
    @SerializedName("photos")
    val photos: List<PhotoEntity>,
)