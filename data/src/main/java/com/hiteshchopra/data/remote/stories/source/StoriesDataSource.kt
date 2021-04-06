package com.hiteshchopra.data.remote.stories.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.HomeApiService
import com.hiteshchopra.data.remote.safeApiCall
import com.hiteshchopra.data.remote.stories.model.StoriesList
import kotlinx.coroutines.CoroutineDispatcher

class StoriesDataSource(
    private val homeApiService: HomeApiService,
    private val dispatcher: CoroutineDispatcher
) : IStoriesDataSource {
    override suspend fun getStories(): ApiSafeResult<StoriesList> {
        return safeApiCall(dispatcher = dispatcher) {
            homeApiService.getStories()
        }
    }
}