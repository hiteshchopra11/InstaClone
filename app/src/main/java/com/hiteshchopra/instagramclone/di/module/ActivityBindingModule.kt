package com.hiteshchopra.instagramclone.di.module

import android.content.Context
import com.hiteshchopra.instagramclone.di.qualifier.ActivityContext
import com.hiteshchopra.instagramclone.di.scope.ActivityScope
import com.hiteshchopra.instagramclone.di.scope.FragmentScope
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import com.hiteshchopra.instagramclone.ui.home.HomeActivity
import com.hiteshchopra.instagramclone.ui.home.HomeActivityModule
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.HomeFragment
import com.hiteshchopra.instagramclone.ui.login.LoginActivity
import com.hiteshchopra.instagramclone.ui.login.LoginActivityModule
import com.hiteshchopra.instagramclone.ui.signup.SignUpActivity
import com.hiteshchopra.instagramclone.ui.signup.SignUpActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [LoginActivityModule::class]
    )
    internal abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [SignUpActivityModule::class]
    )
    internal abstract fun bindSignUpActivity(): SignUpActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [HomeActivityModule::class]
    )
    internal abstract fun bindHomeActivity(): HomeActivity

}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
abstract class BaseActivityModule {
    @Binds
    @ActivityContext
    abstract fun provideActivityContext(activity: BaseActivity<*, *>): Context

    @Binds
    @ActivityScope
    abstract fun provideActivity(loginActivity: BaseActivity<*, *>): DaggerAppCompatActivity
}