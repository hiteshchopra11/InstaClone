package com.hiteshchopra.data.remote.search.model

import com.google.gson.annotations.SerializedName

data class ImgList(
    @SerializedName("results")
    val results: List<Result>,
) {
    data class Result(
        @SerializedName("urls")
        val urls: Urls,
    )
}

data class Urls(
    val small: String,
)