package com.hiteshchopra.data.local.notifications.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotificationEntity(
    val heading: String?,
    @PrimaryKey
    val id: String,
    val image: String?,
    val notification: String?,
    val time: String?
)