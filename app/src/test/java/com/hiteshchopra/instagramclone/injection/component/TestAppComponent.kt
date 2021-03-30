package com.hiteshchopra.instagramclone.injection.component

import com.hiteshchopra.domain.injection.UseCaseModule
import com.hiteshchopra.instagramclone.TestApplication
import com.hiteshchopra.instagramclone.injection.module.TestNewRepositoryModule
import com.hiteshchopra.instagramclone.useCaseTest.UseCaseSignUpTest
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        UseCaseModule::class,
        TestNewRepositoryModule::class
    ]
)
interface TestAppComponent : AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<TestApplication>

    fun inject(useCaseTest: UseCaseSignUpTest)
}