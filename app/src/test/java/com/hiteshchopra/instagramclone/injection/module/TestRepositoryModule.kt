package com.hiteshchopra.instagramclone.injection.module

import com.hiteshchopra.data.local.notifications.NotificationDB
import com.hiteshchopra.data.remote.notifications.source.INotificationsRemoteDataSource
import com.hiteshchopra.data.remote.reels.source.IReelsRemoteDataSource
import com.hiteshchopra.data.remote.search.source.ISearchRemoteDataSource
import com.hiteshchopra.data.repository.notifications.NotificationsRepoImpl
import com.hiteshchopra.data.repository.reels.ReelsRepoImpl
import com.hiteshchopra.data.repository.search.SearchRepoImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
object TestRepositoryModule {
    @Singleton
    @JvmStatic
    @Provides
    fun provideSearchRepository(networkSourceRemote: ISearchRemoteDataSource): SearchRepoImpl {
        return SearchRepoImpl(networkSourceRemote)
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideReelsRepository(networkSourceRemote: IReelsRemoteDataSource): ReelsRepoImpl {
        return ReelsRepoImpl(networkSourceRemote)
    }


//    @Singleton
//    @JvmStatic
//    @Provides
//    fun provideNotificationsRepository(
//        networkSourceRemote: INotificationsRemoteDataSource,
//    ): NotificationsRepoImpl {
//        return NotificationsRepoImpl(networkSourceRemote, db)
//    }
}