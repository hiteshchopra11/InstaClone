package com.hiteshchopra.instagramclone.di.module

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.remote.ApiService
import com.hiteshchopra.data.remote.RetrofitHelper
import com.hiteshchopra.instagramclone.utils.AppConstants
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object NetworkModule {
    @Singleton
    @JvmStatic
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideHttpClient(): OkHttpClient {
        return RetrofitHelper.createOkHttpClient()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return RetrofitHelper.createRetrofitClient(okHttpClient, AppConstants.BASE_URL)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideApiService(retrofit: Retrofit): ApiService {
        return ApiService.createRetrofitService(retrofit)
    }
}