package com.hiteshchopra.instagramclone.utils

import com.hiteshchopra.data.remote.search.model.ImgList
import com.hiteshchopra.data.remote.search.model.Result
import com.hiteshchopra.data.remote.search.model.Urls
import com.hiteshchopra.domain.mapper.toImages
import com.hiteshchopra.domain.model.Image
import com.hiteshchopra.domain.model.Reels

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

    fun getReels(): List<Reels> {
        return listOf(
            Reels("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            Reels("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"),
            Reels("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            Reels("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"),
            Reels("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4")
        )
    }
}