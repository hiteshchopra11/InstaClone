package com.hiteshchopra.data.remote.notifications.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.notifications.model.NotificationList
import retrofit2.Response

interface INotificationsRemoteDataSource {
    suspend fun getNotifications(): NotificationList
}