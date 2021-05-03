package com.hiteshchopra.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.local.notifications.NotificationDB
import com.hiteshchopra.data.local.posts.PostsDB
import com.hiteshchopra.data.local.profile.ProfileDB
import com.hiteshchopra.data.local.stories.StoriesDB
import com.hiteshchopra.data.remote.notifications.source.INotificationsRemoteDataSource
import com.hiteshchopra.data.remote.posts.source.IPostsRemoteDataSource
import com.hiteshchopra.data.remote.profile.source.IProfileRemoteDataSource
import com.hiteshchopra.data.remote.reels.source.IReelsRemoteDataSource
import com.hiteshchopra.data.remote.search.source.ISearchRemoteDataSource
import com.hiteshchopra.data.remote.stories.source.IStoriesDataSource
import com.hiteshchopra.data.repository.firebase.FirebaseRepo
import com.hiteshchopra.data.repository.firebase.FirebaseRepoImpl
import com.hiteshchopra.data.repository.notifications.NotificationsRepo
import com.hiteshchopra.data.repository.notifications.NotificationsRepoImpl
import com.hiteshchopra.data.repository.posts.PostsRepo
import com.hiteshchopra.data.repository.posts.PostsRepoImpl
import com.hiteshchopra.data.repository.profile.ProfileRepo
import com.hiteshchopra.data.repository.profile.ProfileRepoImpl
import com.hiteshchopra.data.repository.reels.ReelsRepo
import com.hiteshchopra.data.repository.reels.ReelsRepoImpl
import com.hiteshchopra.data.repository.search.SearchRepo
import com.hiteshchopra.data.repository.search.SearchRepoImpl
import com.hiteshchopra.data.repository.stories.StoriesRepo
import com.hiteshchopra.data.repository.stories.StoriesRepoImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
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
        remoteDataSource: IPostsRemoteDataSource,
        db: PostsDB
    ): PostsRepo {
        return PostsRepoImpl(remoteDataSource, db)
    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideStoriesRepo(
        dataSource: IStoriesDataSource,
        db: StoriesDB
    ): StoriesRepo {
        return StoriesRepoImpl(dataSource, db)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchRepo(
        remoteDataSource: ISearchRemoteDataSource
    ): SearchRepo {
        return SearchRepoImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideReelsRepo(
        reelsDataSource: IReelsRemoteDataSource
    ): ReelsRepo {
        return ReelsRepoImpl(reelsDataSource)
    }

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    @JvmStatic
    fun provideNotificationsRepo(
        notificationsRemoteDataSource: INotificationsRemoteDataSource,
        db: NotificationDB
    ): NotificationsRepo {
        return NotificationsRepoImpl(notificationsRemoteDataSource, db)
    }

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    @JvmStatic
    fun provideProfileRepo(
        profileRemoteDataSource: IProfileRemoteDataSource,
        db: ProfileDB
    ): ProfileRepo {
        return ProfileRepoImpl(profileRemoteDataSource, db)
    }
}