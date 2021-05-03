package com.hiteshchopra.instagramclone.injection.component


import com.hiteshchopra.instagramclone.TestApplication
import com.hiteshchopra.instagramclone.injection.module.TestNetworkModule
import com.hiteshchopra.instagramclone.injection.module.TestRepositoryModule
import com.hiteshchopra.instagramclone.injection.module.TestSourcesModule
import com.hiteshchopra.instagramclone.injection.module.TestUseCaseModule
import com.hiteshchopra.instagramclone.useCaseTest.UseCaseReelsTest
import com.hiteshchopra.instagramclone.useCaseTest.UseCaseSearchTest
import com.hiteshchopra.instagramclone.useCaseTest.UseCaseSignUpTest
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        TestNetworkModule::class,
        TestRepositoryModule::class,
        TestSourcesModule::class,
        TestUseCaseModule::class
    ]
)
interface TestAppComponent : AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<TestApplication>
    fun inject(useCaseTest: UseCaseSignUpTest)
    fun inject(useCaseTest: UseCaseSearchTest)
    fun inject(useCaseTest: UseCaseReelsTest)
}