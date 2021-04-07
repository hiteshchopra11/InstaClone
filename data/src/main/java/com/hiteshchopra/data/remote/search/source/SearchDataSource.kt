package com.hiteshchopra.data.remote.search.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.SearchApiService
import com.hiteshchopra.data.remote.safeApiCall
import com.hiteshchopra.data.remote.search.model.ImgList
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response

class SearchDataSource(
    private val searchApiService: SearchApiService,
    private val dispatcher: CoroutineDispatcher
) : ISearchDataSource {
    override suspend fun getImages(query: String): ApiSafeResult<ImgList> {
        return safeApiCall(dispatcher) {
            searchApiService.searchImage(
                query = query,
            )
        }
    }
}