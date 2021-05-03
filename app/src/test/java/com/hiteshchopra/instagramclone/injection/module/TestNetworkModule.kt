package com.hiteshchopra.instagramclone.injection.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.listener.FirebaseListener
import com.hiteshchopra.data.remote.NotificationsApiService
import com.hiteshchopra.data.remote.ReelsApiService
import com.hiteshchopra.data.remote.SearchApiService
import com.hiteshchopra.data.repository.firebase.FirebaseRepo
import com.hiteshchopra.instagramclone.repository.RepositoryTest
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
object TestNetworkModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return mockk<FirebaseAuth>()
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideFirebaseListener(): FirebaseListener {
        return RepositoryTest()
    }

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

    @Provides
    @Singleton
    @JvmStatic
    @Throws(NullPointerException::class)
    fun provideMockWebServer(): MockWebServer {
        var mockWebServer: MockWebServer? = null
        val thread = Thread {
            mockWebServer = MockWebServer()
            mockWebServer?.start()
        }
        thread.start()
        thread.join()
        return mockWebServer ?: throw NullPointerException("Mock Web Server Could not be started")
    }

    @Provides
    @Singleton
    @JvmStatic
    @Named("baseUrl")
    fun provideBaseUrl(mockWebServer: MockWebServer): String {
        return mockWebServer.url("/").toString()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("baseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchApiService(retrofit: Retrofit): SearchApiService {
        return SearchApiService.createRetrofitService(retrofit)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideReelsApiService(retrofit: Retrofit): ReelsApiService {
        return ReelsApiService.createRetrofitService(retrofit)
    }

//    @Provides
//    @Singleton
//    @JvmStatic
//    fun provideNotificationsApiService(retrofit: Retrofit): NotificationsApiService {
//        return NotificationsApiService.createRetrofitInstance(retrofit)
//    }
}