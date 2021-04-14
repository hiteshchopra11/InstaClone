package com.hiteshchopra.instagramclone.di.module

import android.app.Application
import android.content.Context
import com.hiteshchopra.instagramclone.di.qualifier.ActivityContext
import com.hiteshchopra.instagramclone.di.qualifier.ApplicationContext
import com.hiteshchopra.instagramclone.di.qualifier.DatabaseContext
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @Named("applicationContext")
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