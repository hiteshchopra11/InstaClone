package com.hiteshchopra.instagramclone.injection.module

import com.hiteshchopra.data.remote.NotificationsApiService
import com.hiteshchopra.data.remote.ReelsApiService
import com.hiteshchopra.data.remote.SearchApiService
import com.hiteshchopra.data.remote.notifications.source.INotificationsRemoteDataSource
import com.hiteshchopra.data.remote.notifications.source.NotificationsRemoteDataSource
import com.hiteshchopra.data.remote.reels.source.IReelsRemoteDataSource
import com.hiteshchopra.data.remote.reels.source.ReelsRemoteDataSource
import com.hiteshchopra.data.remote.search.source.ISearchRemoteDataSource
import com.hiteshchopra.data.remote.search.source.SearchRemoteDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
object TestSourcesModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchNetworkSource(
        apiService: SearchApiService,
        dispatcher: CoroutineDispatcher
    ): ISearchRemoteDataSource {
        return SearchRemoteDataSource(
            apiService, dispatcher
        )
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideReelsNetworkSource(
        apiService: ReelsApiService,
        dispatcher: CoroutineDispatcher
    ): IReelsRemoteDataSource {
        return ReelsRemoteDataSource(
            apiService, dispatcher
        )
    }

//    @Provides
//    @Singleton
//    @JvmStatic
//    fun provideNotificationsDataSource(
//        apiService: NotificationsApiService,
//        dispatcher: CoroutineDispatcher
//    ): INotificationsRemoteDataSource {
//        return NotificationsRemoteDataSource(
//            apiService, dispatcher
//        )
//    }

}