package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.notifications.model.NotificationList
import com.hiteshchopra.domain.model.Notification

fun NotificationList.toNotification(): List<Notification> {
    return this.map { notification ->
        Notification(
            notification.heading,
            notification.id,
            notification.image,
            notification.notification,
            notification.time
        )
    }
}