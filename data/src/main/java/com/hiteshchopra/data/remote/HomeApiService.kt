package com.hiteshchopra.data.remote

import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.stories.model.StoriesList
import retrofit2.Retrofit
import retrofit2.http.GET

interface HomeApiService {
    companion object {
        fun createRetrofitService(retrofit: Retrofit): HomeApiService {
            return retrofit.create(HomeApiService::class.java)
        }
    }

    //TODO wrap in Response
    @GET("/posts")
    suspend fun getPosts(): PostList

    @GET("/stories")
    suspend fun getStories(): StoriesList
}