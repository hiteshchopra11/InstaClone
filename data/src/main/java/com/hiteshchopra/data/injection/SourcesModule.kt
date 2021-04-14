package com.hiteshchopra.data.injection

import com.hiteshchopra.data.remote.HomeApiService
import com.hiteshchopra.data.remote.SearchApiService
import com.hiteshchopra.data.remote.posts.source.IPostsRemoteDataSource
import com.hiteshchopra.data.remote.posts.source.PostsRemoteDataSource
import com.hiteshchopra.data.remote.search.source.ISearchRemoteDataSource
import com.hiteshchopra.data.remote.search.source.SearchRemoteDataSource
import com.hiteshchopra.data.remote.stories.source.IStoriesDataSource
import com.hiteshchopra.data.remote.stories.source.StoriesDataSource
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
        homeApiService: HomeApiService,
        dispatcher: CoroutineDispatcher
    ): IPostsRemoteDataSource {
        return PostsRemoteDataSource(
            homeApiService,
            dispatcher
        )
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideStoriesNetworkSource(
        homeApiService: HomeApiService,
        dispatcher: CoroutineDispatcher
    ): IStoriesDataSource {
        return StoriesDataSource(
            homeApiService,
            dispatcher
        )
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchNetworkSource(
        searchApiService: SearchApiService,
        dispatcher: CoroutineDispatcher
    ): ISearchRemoteDataSource {
        return SearchRemoteDataSource(
            searchApiService,
            dispatcher
        )
    }
}