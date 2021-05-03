package com.hiteshchopra.data.remote

import com.hiteshchopra.data.remote.profile.model.ProfileResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileApiService {

    companion object {
        fun createRetrofitInstance(retrofit: Retrofit): ProfileApiService {
            return retrofit.create(ProfileApiService::class.java)
        }
    }

    @GET("/profile/{id}")
    suspend fun getProfile(@Path("id") id: String): ProfileResponse
}