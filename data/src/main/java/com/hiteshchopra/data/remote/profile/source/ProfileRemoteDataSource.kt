package com.hiteshchopra.data.remote.profile.source

import com.hiteshchopra.data.remote.ProfileApiService
import com.hiteshchopra.data.remote.profile.model.ProfileResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ProfileRemoteDataSource(
    private val profileApiService: ProfileApiService,
    private val dispatcher: CoroutineDispatcher
) : IProfileRemoteDataSource {
    override suspend fun getProfile(id: String): ProfileResponse {
        return withContext(dispatcher) {
            profileApiService.getProfile(id)
        }
    }
}