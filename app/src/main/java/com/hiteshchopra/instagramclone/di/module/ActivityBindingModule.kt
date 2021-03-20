package com.hiteshchopra.instagramclone.di.module

import com.hiteshchopra.instagramclone.di.scope.ActivityScope
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
}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {
}