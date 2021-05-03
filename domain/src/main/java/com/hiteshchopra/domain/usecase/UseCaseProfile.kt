package com.hiteshchopra.domain.usecase

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.profile.entity.Profile
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.data.repository.profile.ProfileRepo
import kotlinx.coroutines.flow.Flow

class UseCaseProfile(
    private val profileRepo: ProfileRepo
) : BaseUseCase<Any?, String> {
    override suspend fun perform(executableParam: String): Flow<ApiSafeResult<ProfileEntity>> {
        return profileRepo.getProfile(executableParam)
    }
}