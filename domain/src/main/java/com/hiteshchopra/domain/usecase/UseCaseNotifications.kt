package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.data.repository.notifications.NotificationsRepo
import kotlinx.coroutines.flow.Flow

class UseCaseNotifications(
    private val notificationsRepo: NotificationsRepo
) : BaseUseCase<Flow<ApiSafeResult<List<NotificationEntity>>>, Unit> {
    override suspend fun perform(): Flow<ApiSafeResult<List<NotificationEntity>>> {
        return notificationsRepo.getNotifications()
    }
}