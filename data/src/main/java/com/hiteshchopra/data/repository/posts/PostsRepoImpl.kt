package com.hiteshchopra.data.repository.posts

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.posts.source.IPostsDataSource

class PostsRepoImpl(
    private val postsDataSource: IPostsDataSource,
) : PostsRepo {
    override suspend fun getPosts(): ApiSafeResult<PostList> {
        return postsDataSource.getPosts()
    }
}