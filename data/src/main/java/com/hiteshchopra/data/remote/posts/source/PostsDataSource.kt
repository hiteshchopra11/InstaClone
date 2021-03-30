package com.hiteshchopra.data.remote.posts.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.ApiService
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher

class PostsDataSource(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher
) : IPostsDataSource {
    override suspend fun getPosts(): ApiSafeResult<PostList> {
        return safeApiCall(dispatcher = dispatcher){
            apiService.getPosts()
        }
    }
}