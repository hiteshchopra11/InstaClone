package com.hiteshchopra.instagramclone.injection.module

import com.hiteshchopra.data.repository.notifications.NotificationsRepoImpl
import com.hiteshchopra.data.repository.reels.ReelsRepoImpl
import com.hiteshchopra.data.repository.search.SearchRepoImpl
import com.hiteshchopra.domain.usecase.UseCaseNotifications
import com.hiteshchopra.domain.usecase.UseCaseReels
import com.hiteshchopra.domain.usecase.UseCaseSearch
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
object TestUseCaseModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideUseCaseSearch(searchRepo: SearchRepoImpl) = UseCaseSearch(searchRepo)

    @Provides
    @Singleton
    @JvmStatic
    fun provideUseCaseReels(reelsRepo: ReelsRepoImpl) = UseCaseReels(reelsRepo)

//    @Provides
//    @Singleton
//    @JvmStatic
//    fun provideUseNotifications(notificationsRepo: NotificationsRepoImpl) =
//        UseCaseNotifications(notificationsRepo)
}