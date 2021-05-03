package com.hiteshchopra.data.repository.profile

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.profile.entity.Profile
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.data.local.profile.entity.ProfileWithPosts
import com.hiteshchopra.data.local.profile.entity.ProfileWithReels
import com.hiteshchopra.data.local.profile.entity.ProfileWithStories
import com.hiteshchopra.data.local.profile.entity.ProfileWithTagged
import kotlinx.coroutines.flow.Flow

interface ProfileRepo {
    suspend fun getProfile(id: String): Flow<ApiSafeResult<ProfileEntity>>
//    suspend fun getProfilePosts(id: String): Flow<ApiSafeResult<ProfileWithPosts>>
//    suspend fun getProfileStories(id: String): Flow<ApiSafeResult<ProfileWithStories>>
//    suspend fun getProfileReels(id: String): Flow<ApiSafeResult<ProfileWithReels>>
//    suspend fun getProfileTagged(id: String): Flow<ApiSafeResult<ProfileWithTagged>>
}