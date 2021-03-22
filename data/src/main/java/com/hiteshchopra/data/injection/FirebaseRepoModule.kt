package com.hiteshchopra.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.repository.FirebaseRepo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
object FirebaseRepoModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseRepo(
        dispatcher: CoroutineDispatcher,
        firebaseAuth: FirebaseAuth
    ): FirebaseRepo {
        return FirebaseRepo(dispatcher, firebaseAuth)
    }
}