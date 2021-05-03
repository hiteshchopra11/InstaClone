package com.hiteshchopra.data.remote.stories.source

import com.hiteshchopra.data.remote.stories.model.StoriesList

interface IStoriesDataSource {
    suspend fun getStories(): StoriesList
}