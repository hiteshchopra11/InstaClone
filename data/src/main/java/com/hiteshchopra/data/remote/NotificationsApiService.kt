package com.hiteshchopra.data.remote

import com.hiteshchopra.data.remote.notifications.model.NotificationList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface NotificationsApiService {
    companion object {
        fun createRetrofitInstance(retrofit: Retrofit): NotificationsApiService {
            return retrofit.create(NotificationsApiService::class.java)
        }
    }

    @GET("/notifications")
    suspend fun getNotifications(): NotificationList
}