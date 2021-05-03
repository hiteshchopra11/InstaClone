package com.hiteshchopra.data.local.profile.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProfileWithReels(
    @Embedded val profileReels: Profile,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val reels: List<ProfileReels>
)