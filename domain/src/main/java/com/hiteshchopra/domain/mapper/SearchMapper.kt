package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.domain.model.Image

fun ImgList.toImages(): List<Image> {
    return this.results.map { response ->
        Image(response.urls.small)
    }
}