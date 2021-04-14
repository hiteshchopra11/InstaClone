package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.entity.PostsEntity
import com.hiteshchopra.data.repository.posts.PostsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class UseCasePosts(
    private val postsRepo: PostsRepo
) : BaseUseCase<Any?, Any?> {
    override suspend fun perform(): Flow<ApiSafeResult<List<PostsEntity>>> {
        return postsRepo.getPosts()
    }
}