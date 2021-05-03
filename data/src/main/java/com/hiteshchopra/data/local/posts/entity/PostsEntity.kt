package com.hiteshchopra.data.local.posts.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PostsEntity(
    @SerializedName("commentsCount")
    val commentsCount: Int,
    @SerializedName("postImage")
    val postImage: String,
    @SerializedName("storiesImage")
    val storiesImage: String,
    @SerializedName("likesCount")
    val likesCount: Int,
    @SerializedName("location")
    val location: String,
    @PrimaryKey
    @SerializedName("name")
    val name: String
)