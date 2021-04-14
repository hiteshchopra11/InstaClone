package com.hiteshchopra.instagramclone.fakes

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.data.remote.search.model.Result
import com.hiteshchopra.data.remote.search.model.Urls
import com.hiteshchopra.data.repository.search.SearchRepo

class FakeSearchRepository : SearchRepo {
    override suspend fun searchImages(query: String): ApiSafeResult<ImgList> {
        return if (query == "Invalid Query") {
            ApiSafeResult.NetworkError
        } else {
            ApiSafeResult.Success(
                ImgList(
                    listOf<Result>(
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random")),
                        Result(Urls("https://source.unsplash.com/random"))
                    )
                )
            )
        }
    }
}