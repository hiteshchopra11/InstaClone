package com.hiteshchopra.data.repository.profile

import androidx.room.withTransaction
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.profile.ProfileDB
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.data.remote.profile.source.IProfileRemoteDataSource
import com.hiteshchopra.data.utils.networkBoundResource
import com.hiteshchopra.data.utils.toProfileEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class ProfileRepoImpl(
    private val profileRemoteDataSource: IProfileRemoteDataSource,
    private val db: ProfileDB
) : ProfileRepo {
    private val dao = db.getProfileDao()
    override suspend fun getProfile(id: String): Flow<ApiSafeResult<ProfileEntity>> {
        return networkBoundResource(
            query = { dao.getProfile() },
            fetch = { profileRemoteDataSource.getProfile(id) },
            saveFetchResult = { profile ->
                db.withTransaction {
                    dao.insertProfile(profile.toProfileEntity())
                }
            },
        )
    }
}