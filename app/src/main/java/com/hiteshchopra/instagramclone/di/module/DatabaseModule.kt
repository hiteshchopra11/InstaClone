package com.hiteshchopra.instagramclone.di.module

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.hiteshchopra.data.local.notifications.NotificationDB
import com.hiteshchopra.data.local.posts.PostsDB
import com.hiteshchopra.data.local.profile.ProfileDB
import com.hiteshchopra.data.local.stories.StoriesDB
import com.hiteshchopra.instagramclone.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    internal fun providePostsDB(@ApplicationContext context: Context): PostsDB {
        return databaseBuilder(context, PostsDB::class.java, PostsDB.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    internal fun provideNotificationsDB(@ApplicationContext context: Context): NotificationDB {
        return databaseBuilder(context, NotificationDB::class.java, NotificationDB.DB_NAME).build()
    }

    @Singleton
    @Provides
    internal fun provideStoriesDB(@ApplicationContext context: Context): StoriesDB {
        return databaseBuilder(context, StoriesDB::class.java, StoriesDB.DB_NAME).build()
    }

    @Singleton
    @Provides
    internal fun provideProfileDB(@ApplicationContext context: Context): ProfileDB {
        return databaseBuilder(context, ProfileDB::class.java, ProfileDB.DB_NAME).build()
    }
}