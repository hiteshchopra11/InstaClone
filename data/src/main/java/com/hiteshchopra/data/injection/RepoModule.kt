package com.hiteshchopra.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.remote.posts.source.IPostsDataSource
import com.hiteshchopra.data.remote.search.source.ISearchDataSource
import com.hiteshchopra.data.remote.search.source.SearchDataSource
import com.hiteshchopra.data.remote.stories.source.IStoriesDataSource
import com.hiteshchopra.data.repository.firebase.FirebaseRepo
import com.hiteshchopra.data.repository.firebase.FirebaseRepoImpl
import com.hiteshchopra.data.repository.posts.PostsRepo
import com.hiteshchopra.data.repository.posts.PostsRepoImpl
import com.hiteshchopra.data.repository.search.SearchRepo
import com.hiteshchopra.data.repository.search.SearchRepoImpl
import com.hiteshchopra.data.repository.stories.StoriesRepo
import com.hiteshchopra.data.repository.stories.StoriesRepoImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
object RepoModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseRepo(
        dispatcher: CoroutineDispatcher,
        firebaseAuth: FirebaseAuth,
    ): FirebaseRepo {
        return FirebaseRepoImpl(dispatcher, firebaseAuth)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providePostRepo(
        dataSource: IPostsDataSource
    ): PostsRepo {
        return PostsRepoImpl(dataSource)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideStoriesRepo(
        dataSource: IStoriesDataSource
    ): StoriesRepo {
        return StoriesRepoImpl(dataSource)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchRepo(
        dataSource: ISearchDataSource
    ): SearchRepo {
        return SearchRepoImpl(dataSource)
    }
}