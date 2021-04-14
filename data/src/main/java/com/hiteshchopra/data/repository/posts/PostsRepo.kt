package com.hiteshchopra.data.repository.posts

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.entity.PostsEntity
import com.hiteshchopra.data.remote.posts.model.PostList
import kotlinx.coroutines.flow.Flow

interface PostsRepo {
    suspend fun getPosts(): Flow<ApiSafeResult<List<PostsEntity>>>
}