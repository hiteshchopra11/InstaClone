package com.hiteshchopra.data.repository.reels

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.reels.model.ReelsList

interface ReelsRepo {
    suspend fun getReels():ApiSafeResult<ReelsList>
}