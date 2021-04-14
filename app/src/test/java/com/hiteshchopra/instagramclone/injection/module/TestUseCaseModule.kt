package com.hiteshchopra.instagramclone.injection.module

import com.hiteshchopra.data.repository.search.SearchRepoImpl
import com.hiteshchopra.domain.usecase.UseCaseSearch
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestUseCaseModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideUseCaseSearch(searchRepo: SearchRepoImpl) = UseCaseSearch(searchRepo)
}