package com.hiteshchopra.data.remote.profile.source

import com.hiteshchopra.data.remote.profile.model.ProfileResponse

interface IProfileRemoteDataSource {
    suspend fun getProfile(id: String): ProfileResponse
}