package com.hiteshchopra.data.repository.notifications

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import kotlinx.coroutines.flow.Flow

interface NotificationsRepo {
    suspend fun getNotifications(): Flow<ApiSafeResult<List<NotificationEntity>>>
}