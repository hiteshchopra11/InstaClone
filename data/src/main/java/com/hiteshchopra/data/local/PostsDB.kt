package com.hiteshchopra.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.hiteshchopra.data.local.dao.PostsDao
import com.hiteshchopra.data.local.entity.PostsEntity

@Database(entities = [PostsEntity::class], version = 1)
abstract class PostsDB : RoomDatabase() {
    companion object {
        const val DB_NAME = "posts_db"
    }

    abstract fun getPostsDao(): PostsDao
}