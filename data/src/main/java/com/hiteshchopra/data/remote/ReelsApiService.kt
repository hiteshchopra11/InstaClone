package com.hiteshchopra.data.remote

import com.hiteshchopra.data.remote.reels.model.ReelsList
import retrofit2.Retrofit
import retrofit2.http.GET

interface ReelsApiService {
    companion object {
        fun createRetrofitService(retrofit: Retrofit): ReelsApiService {
            return retrofit.create(ReelsApiService::class.java)
        }
    }

    @GET("/videos")
    suspend fun getReels(): ReelsList
}