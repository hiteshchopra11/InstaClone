package com.hiteshchopra.data.repository

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.posts.model.PostList

interface PostsRepo {
    suspend fun getPosts(): ApiSafeResult<PostList>
}