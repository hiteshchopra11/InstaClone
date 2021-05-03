package com.hiteshchopra.data.repository.reels

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.reels.model.ReelsList
import com.hiteshchopra.data.remote.reels.source.IReelsRemoteDataSource

class ReelsRepoImpl(
    private val dataSource: IReelsRemoteDataSource
) : ReelsRepo {
    override suspend fun getReels(): ApiSafeResult<ReelsList> {
        return dataSource.getReels()
    }
}