package com.hiteshchopra.data.local.stories.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiteshchopra.data.local.stories.entity.StoriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(list: List<StoriesEntity>)

    @Query("SELECT * FROM StoriesEntity")
    fun getStories(): Flow<List<StoriesEntity>>
}