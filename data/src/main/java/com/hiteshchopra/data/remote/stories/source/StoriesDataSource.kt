package com.hiteshchopra.data.remote.stories.source

import com.hiteshchopra.data.remote.HomeApiService
import com.hiteshchopra.data.remote.stories.model.StoriesList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class StoriesDataSource(
    private val homeApiService: HomeApiService,
    private val dispatcher: CoroutineDispatcher
) : IStoriesDataSource {
    override suspend fun getStories(): StoriesList {
        return withContext(dispatcher) {
            homeApiService.getStories()
        }
    }
}