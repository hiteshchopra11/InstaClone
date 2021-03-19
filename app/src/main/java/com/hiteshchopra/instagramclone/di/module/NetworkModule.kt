package com.hiteshchopra.instagramclone.di.module

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class NetworkModule {
    @Provides
    fun provideFirebaseAuth():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideDispatcher():CoroutineDispatcher {
        return Dispatchers.IO
    }
}