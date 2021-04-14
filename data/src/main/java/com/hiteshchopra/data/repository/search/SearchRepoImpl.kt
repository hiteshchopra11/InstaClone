package com.hiteshchopra.data.repository.search

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.data.remote.search.source.ISearchRemoteDataSource

class SearchRepoImpl(
    private val searchRemoteDataSource: ISearchRemoteDataSource
) : SearchRepo {
    override suspend fun searchImages(query: String): ApiSafeResult<ImgList> {
        return searchRemoteDataSource.getImages(query)
    }
}