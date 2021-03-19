package com.hiteshchopra.data.injection

import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.data.sources.IFirebaseSignInDataSource
import com.hiteshchopra.data.sources.IFirebaseSignUpDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FirebaseRepoModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseRepo(
        firebaseSignUpDataSource: IFirebaseSignUpDataSource,
        firebaseSignInDataSource: IFirebaseSignInDataSource
    ): FirebaseRepo {
        return FirebaseRepo(firebaseSignUpDataSource, firebaseSignInDataSource)
    }
}