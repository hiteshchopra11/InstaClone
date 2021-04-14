package com.hiteshchopra.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PostsEntity(
    @SerializedName("commentsCount")
    val commentsCount: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("likesCount")
    val likesCount: Int,
    @SerializedName("location")
    val location: String,
    @PrimaryKey
    @SerializedName("name")
    val name: String
)