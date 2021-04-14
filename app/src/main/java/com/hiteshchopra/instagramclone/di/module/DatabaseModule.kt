package com.hiteshchopra.instagramclone.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room.databaseBuilder
import com.hiteshchopra.data.local.PostsDB
import com.hiteshchopra.instagramclone.di.qualifier.ApplicationContext
import com.hiteshchopra.instagramclone.di.qualifier.DatabaseContext
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    internal fun provideDb(@Named("applicationContext") context: Context): PostsDB {
        return databaseBuilder(context, PostsDB::class.java, PostsDB.DB_NAME).build()
    }
}