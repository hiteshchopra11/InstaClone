package com.hiteshchopra.data.remote.reels.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.ReelsApiService
import com.hiteshchopra.data.remote.reels.model.ReelsList
import com.hiteshchopra.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher

class ReelsRemoteDataSource(
    private val reelsApiService: ReelsApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : IReelsRemoteDataSource {
    override suspend fun getReels(): ApiSafeResult<ReelsList> {
        return safeApiCall(coroutineDispatcher) {
            reelsApiService.getReels()
        }
    }
}