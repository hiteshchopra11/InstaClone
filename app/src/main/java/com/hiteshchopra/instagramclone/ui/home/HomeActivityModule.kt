package com.hiteshchopra.instagramclone.ui.home

import com.hiteshchopra.instagramclone.di.module.BaseActivityModule
import com.hiteshchopra.instagramclone.di.scope.FragmentScope
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.AccountFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.posts.PostsFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.reels.ProfileReelsFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.tagged.TaggedFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.HomeFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.notificationsfragment.NotificationsFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.ReelsFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showHomeScreenFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showSearchFragment(): SearchFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showReelsFragment(): ReelsFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showNotificationsFragment(): NotificationsFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showAccountFragment(): AccountFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showPostsFragment(): PostsFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showProfileReelsFragment(): ProfileReelsFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun showTaggedFragment(): TaggedFragment

}