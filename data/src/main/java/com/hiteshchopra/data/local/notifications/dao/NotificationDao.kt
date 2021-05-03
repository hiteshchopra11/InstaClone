package com.hiteshchopra.data.local.notifications.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDao {

    //Flow is cold so no need of suspending functions
    @Query("SELECT * FROM NotificationEntity LIMIT 20")
    fun getNotifications(): Flow<List<NotificationEntity>>

    @Query("DELETE FROM NotificationEntity")
    suspend fun deleteAllNotifications()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotifications(list: List<NotificationEntity>)
}