package com.hiteshchopra.data.repository.stories

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.stories.model.StoriesList

interface StoriesRepo {
    suspend fun getStories(): ApiSafeResult<StoriesList>
}