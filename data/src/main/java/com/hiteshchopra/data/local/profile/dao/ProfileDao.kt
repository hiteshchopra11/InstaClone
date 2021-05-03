package com.hiteshchopra.data.local.profile.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.hiteshchopra.data.local.profile.entity.Profile
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.data.local.profile.entity.ProfilePosts
import com.hiteshchopra.data.local.profile.entity.ProfileReels
import com.hiteshchopra.data.local.profile.entity.ProfileStories
import com.hiteshchopra.data.local.profile.entity.ProfileTagged
import com.hiteshchopra.data.local.profile.entity.ProfileWithPosts
import com.hiteshchopra.data.local.profile.entity.ProfileWithReels
import com.hiteshchopra.data.local.profile.entity.ProfileWithStories
import com.hiteshchopra.data.local.profile.entity.ProfileWithTagged
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Transaction
    @Query("SELECT * FROM ProfileEntity")
    fun getProfile(): Flow<ProfileEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: ProfileEntity)

}