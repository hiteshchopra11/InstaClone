package com.hiteshchopra.data.local.notifications

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hiteshchopra.data.local.notifications.dao.NotificationDao
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.data.local.posts.dao.PostsDao

@Database(entities = [NotificationEntity::class], version = 1)
abstract class NotificationDB : RoomDatabase() {
    companion object {
        const val DB_NAME = "notifications_db"
    }

    abstract fun getNotificationsDao(): NotificationDao
}