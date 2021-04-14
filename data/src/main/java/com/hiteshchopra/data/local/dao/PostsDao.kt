package com.hiteshchopra.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiteshchopra.data.local.entity.PostsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PostsDao {

    //Flow is cold so no need of suspending functions
    @Query("SELECT * FROM PostsEntity LIMIT 20")
    fun getPosts(): Flow<List<PostsEntity>>

    @Query("DELETE FROM PostsEntity")
    suspend fun deleteAllPosts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMulPosts(list: List<PostsEntity>)

}