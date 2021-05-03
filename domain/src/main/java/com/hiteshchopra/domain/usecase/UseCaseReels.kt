package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.repository.reels.ReelsRepo
import com.hiteshchopra.domain.mapper.toReels
import com.hiteshchopra.domain.model.Reels

class UseCaseReels(private val repo: ReelsRepo) : BaseUseCase<ApiSafeResult<List<Reels>>, Unit> {
    override suspend fun perform(): ApiSafeResult<List<Reels>> {
        return when (val result = repo.getReels()) {
            is ApiSafeResult.Success -> ApiSafeResult.Success(result.data.toReels())
            is ApiSafeResult.Failure -> ApiSafeResult.Failure(result.data?.toReels())
            is ApiSafeResult.NetworkError -> result
            else -> ApiSafeResult.Failure()
        }
    }
}