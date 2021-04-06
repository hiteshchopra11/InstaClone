package com.hiteshchopra.data.remote.posts.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.HomeApiService
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher

class PostsDataSource(
    private val homeApiService: HomeApiService,
    private val dispatcher: CoroutineDispatcher
) : IPostsDataSource {
    override suspend fun getPosts(): ApiSafeResult<PostList> {
        return safeApiCall(dispatcher = dispatcher){
            homeApiService.getPosts()
        }
    }
}