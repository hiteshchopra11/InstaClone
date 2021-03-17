package com.hiteshchopra.instagramclone.di.module

import com.hiteshchopra.instagramclone.di.scope.ActivityScope
import com.hiteshchopra.instagramclone.ui.login.LoginActivity
import com.hiteshchopra.instagramclone.ui.login.LoginActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

/**
 * To create dependencies for a specific activity, don't extend the required activity module with #ActivityModule, instead create a plain module and include #BaseActivityModule in the annotation.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [LoginActivityModule::class]
    )
    internal abstract fun bindLoginActivity(): LoginActivity

}

@Module(includes = [BaseActivityModule::class])
abstract class ActivityModule<in T : DaggerAppCompatActivity> {
    @Binds
    @ActivityScope
    internal abstract fun bindActivity(activity: T): DaggerAppCompatActivity
}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {
}