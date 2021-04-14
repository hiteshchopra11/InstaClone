package com.hiteshchopra.data.remote.search.source

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.search.model.ImgList
import retrofit2.Response

interface ISearchRemoteDataSource {
    suspend fun getImages(query: String): ApiSafeResult<ImgList>
}