package com.hiteshchopra.data.remote
import com.hiteshchopra.data.remote.search.model.ImgList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {
    companion object {
        fun createRetrofitService(retrofit: Retrofit): SearchApiService {
            return retrofit.create(SearchApiService::class.java)
        }
    }

    @GET("/search/photos")
    suspend fun searchImage(
        @Query("query") query: String,
    ): ImgList
}