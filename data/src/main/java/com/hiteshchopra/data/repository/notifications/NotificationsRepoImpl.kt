package com.hiteshchopra.data.repository.notifications

import androidx.room.withTransaction
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.notifications.NotificationDB
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.data.remote.notifications.source.INotificationsRemoteDataSource
import com.hiteshchopra.data.utils.networkBoundResource
import com.hiteshchopra.data.utils.toNotificationEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class NotificationsRepoImpl(
    private val dataSource: INotificationsRemoteDataSource,
    private val db: NotificationDB
) : NotificationsRepo {
    private val dao = db.getNotificationsDao()
    override suspend fun getNotifications(): Flow<ApiSafeResult<List<NotificationEntity>>> {
        return networkBoundResource(
            query = { dao.getNotifications() },
            fetch = { dataSource.getNotifications() },
            saveFetchResult = { notifications ->
                db.withTransaction {
                    dao.insertNotifications(notifications.toNotificationEntity())
                }
            })
    }
}