package com.hiteshchopra.instagramclone.injection.module

import com.hiteshchopra.data.remote.search.source.ISearchRemoteDataSource
import com.hiteshchopra.data.repository.search.SearchRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestRepositoryModule {
    @Singleton
    @JvmStatic
    @Provides
    fun provideSearchRepository(networkSourceRemote: ISearchRemoteDataSource): SearchRepoImpl {
        return SearchRepoImpl(networkSourceRemote)
    }
}