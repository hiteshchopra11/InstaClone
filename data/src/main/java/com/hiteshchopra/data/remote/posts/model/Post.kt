package com.hiteshchopra.data.remote.posts.model

import com.google.gson.annotations.SerializedName

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
)