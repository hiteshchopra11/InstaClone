package com.hiteshchopra.instagramclone.di.module

import android.content.Context
import com.hiteshchopra.instagramclone.di.qualifier.ActivityContext
import com.hiteshchopra.instagramclone.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(@ApplicationContext applicationContext: Context): Context {
        return applicationContext
    }

    @Provides
    @Singleton
    @ActivityContext
    fun provideActivityContext(@ActivityContext activityContext: Context): Context {
        return activityContext
    }
}