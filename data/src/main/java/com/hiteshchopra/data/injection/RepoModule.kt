package com.hiteshchopra.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.remote.posts.source.IPostsDataSource
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.data.repository.PostsRepo
import com.hiteshchopra.data.repository.RepoImpl
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
        dataSource: IPostsDataSource
    ): FirebaseRepo {
        return RepoImpl(dispatcher, firebaseAuth, dataSource)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providePostRepo(
        dispatcher: CoroutineDispatcher,
        firebaseAuth: FirebaseAuth,
        dataSource: IPostsDataSource
    ): PostsRepo {
        return RepoImpl(dispatcher, firebaseAuth, dataSource)
    }
}