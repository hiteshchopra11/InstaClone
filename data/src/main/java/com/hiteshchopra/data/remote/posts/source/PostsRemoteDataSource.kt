package com.hiteshchopra.data.remote.posts.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.data.remote.HomeApiService
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PostsRemoteDataSource(
    private val homeApiService: HomeApiService,
    private val dispatcher: CoroutineDispatcher
) : IPostsRemoteDataSource {
    override suspend fun getPosts():PostList {
        return withContext(dispatcher){
            homeApiService.getPosts()
        }
    }
}