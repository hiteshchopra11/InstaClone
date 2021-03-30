package com.hiteshchopra.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.data.repository.FirebaseRepoImpl
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
        return FirebaseRepoImpl(dispatcher,firebaseAuth)
    }
}