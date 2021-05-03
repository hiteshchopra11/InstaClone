package com.hiteshchopra.data.local.profile.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProfileWithStories(
    @Embedded val profileStories: Profile,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val stories: List<ProfileStories>
)