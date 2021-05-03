package com.hiteshchopra.data.repository.stories

import androidx.room.withTransaction
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.stories.StoriesDB
import com.hiteshchopra.data.local.stories.entity.StoriesEntity
import com.hiteshchopra.data.remote.stories.source.IStoriesDataSource
import com.hiteshchopra.data.utils.networkBoundResource
import com.hiteshchopra.data.utils.toStoriesEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class StoriesRepoImpl(
    private val storiesDataSource: IStoriesDataSource,
    private val db: StoriesDB
) : StoriesRepo {
    private val dao = db.getStoriesDao()
    override suspend fun getStories(): Flow<ApiSafeResult<List<StoriesEntity>>> {
        return networkBoundResource(
            query = { dao.getStories() },
            fetch = { storiesDataSource.getStories() },
            saveFetchResult = { stories ->
                db.withTransaction {
                    dao.insertStories(stories.toStoriesEntity())
                }
            },
        )
    }
}