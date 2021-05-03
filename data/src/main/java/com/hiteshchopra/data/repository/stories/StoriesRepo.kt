package com.hiteshchopra.data.repository.stories

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.stories.entity.StoriesEntity
import kotlinx.coroutines.flow.Flow

interface StoriesRepo {
    suspend fun getStories(): Flow<ApiSafeResult<List<StoriesEntity>>>
}