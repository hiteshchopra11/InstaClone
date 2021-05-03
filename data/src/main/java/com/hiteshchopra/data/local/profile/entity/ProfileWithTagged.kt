package com.hiteshchopra.data.local.profile.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProfileWithTagged(
    @Embedded val profileTagged: Profile,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val tagged: List<ProfileTagged>
)