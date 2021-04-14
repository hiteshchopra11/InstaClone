package com.hiteshchopra.instagramclone.utils

import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.data.remote.search.model.Result
import com.hiteshchopra.data.remote.search.model.Urls
import com.hiteshchopra.domain.mapper.toImages
import com.hiteshchopra.domain.model.Image

object DummyDataUtils {
    fun getImages(): List<Image> {
        return ImgList(
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
        ).toImages()
    }
}