package com.hiteshchopra.data.remote.reels.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.reels.model.ReelsList

interface IReelsRemoteDataSource {
    suspend fun getReels(): ApiSafeResult<ReelsList>
}