package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.reels.model.ReelsList
import com.hiteshchopra.domain.model.Reels

fun ReelsList.toReels():List<Reels>{
    return this.map { reels->
        Reels(reels.videos)
    }
}