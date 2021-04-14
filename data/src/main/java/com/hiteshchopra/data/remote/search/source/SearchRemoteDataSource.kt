package com.hiteshchopra.data.remote.search.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.SearchApiService
import com.hiteshchopra.data.remote.safeApiCall
import com.hiteshchopra.data.remote.search.model.ImgList
import kotlinx.coroutines.CoroutineDispatcher

class SearchRemoteDataSource(
    private val searchApiService: SearchApiService,
    private val dispatcher: CoroutineDispatcher
) : ISearchRemoteDataSource {
    override suspend fun getImages(query: String): ApiSafeResult<ImgList> {
        return safeApiCall(dispatcher) {
            searchApiService.searchImage(
                query = query,
            )
        }
    }
}