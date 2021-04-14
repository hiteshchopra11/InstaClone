package com.hiteshchopra.instagramclone.ui.home

import android.content.Context
import androidx.room.Room
import com.hiteshchopra.data.local.PostsDB
import com.hiteshchopra.instagramclone.di.module.BaseActivityModule
import com.hiteshchopra.instagramclone.di.qualifier.DatabaseContext
import com.hiteshchopra.instagramclone.di.scope.FragmentScope
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.HomeFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.SearchFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.SearchFragmentVM
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showHomeScreenFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showSearchFragment(): SearchFragment

}