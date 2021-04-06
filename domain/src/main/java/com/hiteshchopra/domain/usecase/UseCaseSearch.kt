package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.repository.search.SearchRepo
import com.hiteshchopra.domain.mapper.toImages
import com.hiteshchopra.domain.model.Image

class UseCaseSearch(
    private val searchRepo: SearchRepo
) : BaseUseCase<ApiSafeResult<List<Image>>, String> {
    override suspend fun perform(executableParam: String): ApiSafeResult<List<Image>> {
        return when (val result = searchRepo.searchImages(executableParam)) {
            is ApiSafeResult.Success -> ApiSafeResult.Success(result.data.toImages())
            is ApiSafeResult.NetworkError -> result
            is ApiSafeResult.Failure -> result
        }
    }
}