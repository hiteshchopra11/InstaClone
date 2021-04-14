package com.hiteshchopra.data.remote

import com.hiteshchopra.data.local.entity.PostsEntity
import com.hiteshchopra.data.remote.stories.model.StoriesList
import retrofit2.Retrofit
import retrofit2.http.GET

interface HomeApiService {
    companion object {
        fun createRetrofitService(retrofit: Retrofit): HomeApiService {
            return retrofit.create(HomeApiService::class.java)
        }
    }

    @GET("/posts")
    suspend fun getPosts(): List<PostsEntity>

    @GET("/stories")
    suspend fun getStories(): StoriesList
}