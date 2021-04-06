package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.domain.model.Image
import retrofit2.Response

fun Response<ImgList>.toImages(): List<com.hiteshchopra.domain.model.Image> {
    return this.body()!!.results.map { response ->
        Image(response.urls.small)
    }
}