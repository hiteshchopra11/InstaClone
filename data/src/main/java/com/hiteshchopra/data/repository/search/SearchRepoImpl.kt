package com.hiteshchopra.data.repository.search

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.data.remote.search.source.ISearchDataSource
import retrofit2.Response

class SearchRepoImpl(
    private val searchDataSource: ISearchDataSource
) : SearchRepo {
    override suspend fun searchImages(query: String): ApiSafeResult<Response<ImgList>> {
        return searchDataSource.getImages(query)
    }
}