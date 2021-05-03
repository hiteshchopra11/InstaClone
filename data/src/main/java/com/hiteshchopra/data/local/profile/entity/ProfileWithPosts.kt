package com.hiteshchopra.data.local.profile.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProfileWithPosts(
    @Embedded(prefix = "posts")
    val profilePosts: Profile,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val posts: List<ProfilePosts>
)