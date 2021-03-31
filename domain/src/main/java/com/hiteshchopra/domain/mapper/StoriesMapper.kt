package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.stories.model.StoriesList

fun StoriesList.toStories(): List<com.hiteshchopra.domain.model.Stories> {
    return this.map { postResponse ->
        com.hiteshchopra.domain.model.Stories(
            postResponse.name,
            postResponse.image
        )
    }
}