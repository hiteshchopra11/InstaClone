package com.hiteshchopra.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.sources.FirebaseSignInDataSource
import com.hiteshchopra.data.sources.FirebaseSignUpDataSource
import com.hiteshchopra.data.sources.IFirebaseSignInDataSource
import com.hiteshchopra.data.sources.IFirebaseSignUpDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
object FirebaseSourcesModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseSignUpDataSource(
        auth: FirebaseAuth,
        dispatcher: CoroutineDispatcher
    ): IFirebaseSignUpDataSource {
        return FirebaseSignUpDataSource(auth,dispatcher)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseSignInDataSource(
        auth: FirebaseAuth,
        dispatcher: CoroutineDispatcher
    ): IFirebaseSignInDataSource {
        return FirebaseSignInDataSource(auth, dispatcher)
    }
}