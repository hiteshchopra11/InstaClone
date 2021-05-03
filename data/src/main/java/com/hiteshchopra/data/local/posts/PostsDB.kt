package com.hiteshchopra.data.local.posts


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hiteshchopra.data.local.posts.dao.PostsDao
import com.hiteshchopra.data.local.posts.entity.PostsEntity

@Database(
    entities = [PostsEntity::class],
    version = 1
)
abstract class PostsDB : RoomDatabase() {

    companion object {
        const val DB_NAME = "posts_db"
//        val MIGRATION_2_3 = object : Migration(2, 3) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//
//                //Create Table PostEntity
//                database.execSQL("CREATE TABLE PostEntity(commentsCount INTEGER NOT NULL,postImage TEXT,storiesImage TEXT,likesCount INTEGER,location TEXT,name TEXT NOT NULL, PRIMARY KEY(name))")
//
//                //Copy the data
//                database.execSQL("INSERT INTO PostEntity(commentsCount,postImage,storiesImage,likesCount,location,name) SELECT commentsCount,postImage,storiesImage,likesCount,location,name FROM PostsEntity")
//
//                // Remove the old table
//                database.execSQL("DROP TABLE PostsEntity")
//
//                //Create Table PostEntity
//                database.execSQL("CREATE TABLE PostsEntity(commentsCount INTEGER NOT NULL,postImage TEXT NOT NULL,storiesImage TEXT NOT NULL,likesCount INTEGER NOT NULL,location TEXT NOT NULL,name TEXT NOT NULL, PRIMARY KEY(name))")
//
//                //Database
//                database.execSQL("INSERT INTO PostsEntity SELECT commentsCount,postImage,storiesImage,likesCount,location,name FROM PostEntity")
//
//                database.execSQL("DROP TABLE PostEntity")
//            }
//        }
    }

    abstract fun getPostsDao(): PostsDao
}