package com.hiteshchopra.data.local.profile

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hiteshchopra.data.local.profile.dao.ProfileDao
import com.hiteshchopra.data.local.profile.entity.ProfileEntity

@Database(entities = [ProfileEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProfileDB : RoomDatabase() {
    companion object {
        const val DB_NAME = "profile_db"
    }

    abstract fun getProfileDao(): ProfileDao
}