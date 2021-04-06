package com.hiteshchopra.domain.injection

import com.hiteshchopra.data.repository.firebase.FirebaseRepo
import com.hiteshchopra.data.repository.posts.PostsRepo
import com.hiteshchopra.data.repository.search.SearchRepo
import com.hiteshchopra.data.repository.stories.StoriesRepo
import com.hiteshchopra.domain.usecase.UseCaseFirebaseLogin
import com.hiteshchopra.domain.usecase.UseCaseFirebaseSignUp
import com.hiteshchopra.domain.usecase.UseCasePosts
import com.hiteshchopra.domain.usecase.UseCaseSearch
import com.hiteshchopra.domain.usecase.UseCaseStories
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UseCaseModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideSignUpUseCase(repo: FirebaseRepo): UseCaseFirebaseSignUp {
        return UseCaseFirebaseSignUp(repo)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideLoginUseCase(repo: FirebaseRepo): UseCaseFirebaseLogin {
        return UseCaseFirebaseLogin(repo)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providePostUseCase(repo: PostsRepo): UseCasePosts {
        return UseCasePosts(postsRepo = repo)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideStoriesUseCase(repo: StoriesRepo): UseCaseStories {
        return UseCaseStories(storiesRepo = repo)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchUseCase(repo: SearchRepo): UseCaseSearch {
        return UseCaseSearch(repo)
    }
}