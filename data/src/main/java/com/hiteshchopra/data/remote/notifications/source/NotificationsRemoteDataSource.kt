package com.hiteshchopra.data.remote.notifications.source

import com.hiteshchopra.data.remote.NotificationsApiService
import com.hiteshchopra.data.remote.notifications.model.NotificationList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class NotificationsRemoteDataSource(
    private val apiService: NotificationsApiService,
    private val dispatcher: CoroutineDispatcher
) : INotificationsRemoteDataSource {
    override suspend fun getNotifications(): NotificationList {
        return withContext(dispatcher) {
            apiService.getNotifications()
        }
    }
}