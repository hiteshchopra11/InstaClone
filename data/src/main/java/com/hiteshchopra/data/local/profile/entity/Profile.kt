package com.hiteshchopra.data.local.profile.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Profile(
    val username: String,
    val followers_count: Int,
    val following_count: Int,
    @PrimaryKey
    val id: String,
    val posts_count: Int,
    val profile_bio: String,
    val profile_name: String,
    val profile_pic: String,
) : Parcelable