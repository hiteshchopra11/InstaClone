package com.hiteshchopra.instagramclone.di.module

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.hiteshchopra.data.local.PostsDB
import com.hiteshchopra.instagramclone.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    internal fun provideDb(@ApplicationContext context: Context): PostsDB {
        return databaseBuilder(context, PostsDB::class.java, PostsDB.DB_NAME).build()
    }
}