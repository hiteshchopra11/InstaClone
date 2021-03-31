package com.hiteshchopra.data.remote

import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.stories.model.StoriesList
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {
    companion object {
        fun createRetrofitService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }
    }

    @GET("/posts")
    suspend fun getPosts(): PostList

    @GET("/stories")
    suspend fun getStories(): StoriesList
}