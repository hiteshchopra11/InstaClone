package com.hiteshchopra.instagramclone.di.module

import android.content.Context
import com.hiteshchopra.instagramclone.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext applicationContext: Context): Context {
        return applicationContext
    }
}