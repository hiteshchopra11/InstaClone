package com.hiteshchopra.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class Post(
    val commentsCount: Int,
    val postImage: String,
    val storiesImage:String,
    val likesCount: Int,
    val location: String,
    val name: String
)