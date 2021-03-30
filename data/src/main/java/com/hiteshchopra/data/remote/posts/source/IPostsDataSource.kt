package com.hiteshchopra.data.remote.posts.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.posts.model.PostList

interface IPostsDataSource {
    suspend fun getPosts():ApiSafeResult<PostList>
}