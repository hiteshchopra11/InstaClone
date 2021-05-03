package com.hiteshchopra.data.local.stories.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoriesEntity(
    val image: String,
    @PrimaryKey
    val name: String
)