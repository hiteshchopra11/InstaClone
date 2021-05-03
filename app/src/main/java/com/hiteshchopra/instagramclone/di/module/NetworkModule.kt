package com.hiteshchopra.instagramclone.di.module

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.remote.HomeApiService
import com.hiteshchopra.data.remote.NotificationsApiService
import com.hiteshchopra.data.remote.ProfileApiService
import com.hiteshchopra.data.remote.ReelsApiService
import com.hiteshchopra.data.remote.RetrofitHelper
import com.hiteshchopra.data.remote.SearchApiService
import com.hiteshchopra.instagramclone.di.qualifier.HomeOkHttpClient
import com.hiteshchopra.instagramclone.di.qualifier.HomeRetrofitInstance
import com.hiteshchopra.instagramclone.di.qualifier.ProfileOkHttpClient
import com.hiteshchopra.instagramclone.di.qualifier.ProfileRetrofitInstance
import com.hiteshchopra.instagramclone.di.qualifier.SearchOkHttpClient
import com.hiteshchopra.instagramclone.di.qualifier.SearchRetrofitInstance
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
    @HomeOkHttpClient
    fun provideHomeHttpClient(): OkHttpClient {
        return RetrofitHelper.createOkHttpClient()
    }


    @Provides
    @Singleton
    @JvmStatic
    @SearchOkHttpClient
    fun provideSearchHttpClient(): OkHttpClient {
        return RetrofitHelper.createSearchOkHttpClient()
    }

    @Provides
    @Singleton
    @JvmStatic
    @ProfileOkHttpClient
    fun provideProfileHttpClient(): OkHttpClient {
        return RetrofitHelper.createOkHttpClient()
    }

    @Provides
    @Singleton
    @JvmStatic
    @HomeRetrofitInstance
    fun provideHomeRetrofit(
        @HomeOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit {
        return RetrofitHelper.createRetrofitClient(okHttpClient, AppConstants.HOME_BASE_URL)
    }

    @Provides
    @Singleton
    @JvmStatic
    @SearchRetrofitInstance
    fun provideSearchRetrofit(
        @SearchOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit {
        return RetrofitHelper.createRetrofitClient(okHttpClient, AppConstants.SEARCH_BASE_URL)
    }

    @Provides
    @Singleton
    @JvmStatic
    @ProfileRetrofitInstance
    fun provideProfileRetrofit(
        @ProfileOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit {
        return RetrofitHelper.createRetrofitClient(okHttpClient, AppConstants.PROFILE_BASE_URL)
    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideHomeApiService(@HomeRetrofitInstance retrofit: Retrofit): HomeApiService {
        return HomeApiService.createRetrofitService(retrofit)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchService(@SearchRetrofitInstance retrofit: Retrofit): SearchApiService {
        return SearchApiService.createRetrofitService(retrofit)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideReelsService(@HomeRetrofitInstance retrofit: Retrofit): ReelsApiService {
        return ReelsApiService.createRetrofitService(retrofit)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideNotificationsService(@HomeRetrofitInstance retrofit: Retrofit): NotificationsApiService {
        return NotificationsApiService.createRetrofitInstance(retrofit)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideProfileNotificationsService(@ProfileRetrofitInstance retrofit: Retrofit): ProfileApiService {
        return ProfileApiService.createRetrofitInstance(retrofit)
    }
}