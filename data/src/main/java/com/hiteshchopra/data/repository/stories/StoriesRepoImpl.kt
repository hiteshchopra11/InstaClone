package com.hiteshchopra.data.repository.stories

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.stories.model.StoriesList
import com.hiteshchopra.data.remote.stories.source.IStoriesDataSource

class StoriesRepoImpl(
    private val storiesDataSource: IStoriesDataSource,
) : StoriesRepo {
    override suspend fun getStories(): ApiSafeResult<StoriesList> {
        return storiesDataSource.getStories()
    }
}