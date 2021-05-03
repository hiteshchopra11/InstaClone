package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.stories.entity.StoriesEntity
import com.hiteshchopra.data.repository.stories.StoriesRepo
import com.hiteshchopra.domain.model.User
import kotlinx.coroutines.flow.Flow

class UseCaseStories(
    private val storiesRepo: StoriesRepo
) : BaseUseCase<Flow<ApiSafeResult<List<StoriesEntity>>>, User> {
    override suspend fun perform(): Flow<ApiSafeResult<List<StoriesEntity>>> {
        return storiesRepo.getStories()
    }
}