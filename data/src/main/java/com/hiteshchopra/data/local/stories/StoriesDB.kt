package com.hiteshchopra.data.local.stories

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hiteshchopra.data.local.stories.dao.StoriesDao
import com.hiteshchopra.data.local.stories.entity.StoriesEntity

@Database(entities = [StoriesEntity::class], version = 1)
abstract class StoriesDB : RoomDatabase() {
    companion object {
        const val DB_NAME = "stories_db"
    }

    abstract fun getStoriesDao(): StoriesDao
}