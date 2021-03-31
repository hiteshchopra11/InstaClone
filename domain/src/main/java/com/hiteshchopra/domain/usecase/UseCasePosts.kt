package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.repository.posts.PostsRepo
import com.hiteshchopra.domain.mapper.toPosts
import com.hiteshchopra.domain.model.Post
import com.hiteshchopra.domain.model.User

class UseCasePosts(
    private val postsRepo: PostsRepo
) : BaseUseCase<ApiSafeResult<List<Post>>, User> {
    override suspend fun perform(): ApiSafeResult<List<Post>> {
        return when (val result = postsRepo.getPosts()) {
            is ApiSafeResult.Success -> ApiSafeResult.Success(result.data.toPosts())
            is ApiSafeResult.NetworkError -> result
            is ApiSafeResult.Failure -> result
        }
    }
}