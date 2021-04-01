package com.hiteshchopra.instagramclone.ui.home

import com.hiteshchopra.instagramclone.di.module.BaseActivityModule
import com.hiteshchopra.instagramclone.di.scope.FragmentScope
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showHomeScreenFragment(): HomeFragment
}