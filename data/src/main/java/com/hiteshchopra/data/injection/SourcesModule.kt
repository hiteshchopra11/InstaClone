package com.hiteshchopra.data.injection

import com.hiteshchopra.data.remote.ApiService
import com.hiteshchopra.data.remote.posts.source.IPostsDataSource
import com.hiteshchopra.data.remote.posts.source.PostsDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton


@Module
object SourcesModule {
    @Provides
    @Singleton
    @JvmStatic
    fun providePostsNetworkSource(
        apiService: ApiService,
        dispatcher: CoroutineDispatcher
    ): IPostsDataSource {
        return PostsDataSource(
            apiService,
            dispatcher
        )
    }
}