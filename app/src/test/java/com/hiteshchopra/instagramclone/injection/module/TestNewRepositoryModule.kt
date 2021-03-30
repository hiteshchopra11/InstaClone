package com.hiteshchopra.instagramclone.injection.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.listener.FirebaseListener
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.data.repository.NewFirebaseRepository
import com.hiteshchopra.instagramclone.repository.RepositoryTest
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object TestNewRepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

//    @Provides
//    @Singleton
//    @JvmStatic
//    fun provideFirebaseAuth(): FirebaseAuth {
//        return mockk<FirebaseAuth>()
//    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseListener(): FirebaseListener {
        return RepositoryTest()
    }

//    @Provides
//    @Singleton
//    @JvmStatic
//    fun provideNewFirebaseRepository(
//        auth: FirebaseAuth,
//        listener: FirebaseListener,
//        dispatcher: CoroutineDispatcher
//    ): NewFirebaseRepository {
//        return NewFirebaseRepository(
//            dispatcher = dispatcher,
//            mAuth = auth,
//            observer = listener
//        )
//    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseRepo(
    ): FirebaseRepo {
        return mockk<FirebaseRepo>()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseUser(): FirebaseUser {
        return mockk<FirebaseUser>()
    }
}