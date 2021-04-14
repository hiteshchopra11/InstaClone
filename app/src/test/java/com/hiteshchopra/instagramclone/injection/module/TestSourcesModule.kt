package com.hiteshchopra.instagramclone.injection.module

import com.hiteshchopra.data.remote.SearchApiService
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
}