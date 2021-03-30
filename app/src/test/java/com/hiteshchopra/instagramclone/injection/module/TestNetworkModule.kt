package com.hiteshchopra.instagramclone.injection.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.repository.FirebaseRepo
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class TestNetworkModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return mockk<FirebaseAuth>()
    }

    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    fun provideFirebaseRepo(
    ): FirebaseRepo {
        return mockk<FirebaseRepo>()
    }

    @Provides
    fun provideFirebaseUser(): FirebaseUser {
        return mockk<FirebaseUser>()
    }
}