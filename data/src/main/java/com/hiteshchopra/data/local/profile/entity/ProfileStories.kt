package com.hiteshchopra.data.local.profile.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Profile::class,
            parentColumns = ["id"],
            childColumns = ["profileId"],
            onDelete = CASCADE
        )]
)
data class ProfileStories(
    @PrimaryKey
    val id: String,
    val profileId: String,
    val stories: String,
)