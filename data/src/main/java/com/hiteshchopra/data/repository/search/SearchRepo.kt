package com.hiteshchopra.data.repository.search

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.search.model.ImgList

interface SearchRepo {
    suspend fun searchImages(query: String): ApiSafeResult<ImgList>
}