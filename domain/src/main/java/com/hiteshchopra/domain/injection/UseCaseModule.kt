package com.hiteshchopra.domain.injection

import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.data.repository.FirebaseRepoImpl
import com.hiteshchopra.domain.usecase.UseCaseFirebaseLogin
import com.hiteshchopra.domain.usecase.UseCaseFirebaseSignUp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UseCaseModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideSignUpUseCase(repo: FirebaseRepo): UseCaseFirebaseSignUp {
        return UseCaseFirebaseSignUp(repo)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideLoginUseCase(repo: FirebaseRepo): UseCaseFirebaseLogin {
        return UseCaseFirebaseLogin(repo)
    }
}