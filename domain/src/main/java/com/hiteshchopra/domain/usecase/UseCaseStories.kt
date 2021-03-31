package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.repository.stories.StoriesRepo
import com.hiteshchopra.domain.mapper.toStories
import com.hiteshchopra.domain.model.Stories
import com.hiteshchopra.domain.model.User

class UseCaseStories(
    private val storiesRepo: StoriesRepo
) : BaseUseCase<ApiSafeResult<List<Stories>>, User> {
    override suspend fun perform(): ApiSafeResult<List<Stories>> {
        return when (val result = storiesRepo.getStories()) {
            is ApiSafeResult.Success -> ApiSafeResult.Success(result.data.toStories())
            is ApiSafeResult.NetworkError -> result
            is ApiSafeResult.Failure -> result
        }
    }
}