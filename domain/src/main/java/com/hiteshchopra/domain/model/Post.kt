package com.hiteshchopra.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    @SerializedName("commentsCount")
    val commentsCount: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("likesCount")
    val likesCount: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String
) : Parcelable