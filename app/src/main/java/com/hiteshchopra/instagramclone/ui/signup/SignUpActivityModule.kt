package com.hiteshchopra.instagramclone.ui.signup

import android.content.Context
import com.hiteshchopra.instagramclone.di.module.BaseActivityModule
import com.hiteshchopra.instagramclone.di.qualifier.ActivityContext
import com.hiteshchopra.instagramclone.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class SignUpActivityModule {

    @Binds
    @ActivityContext
    abstract fun provideActivityContext(activity: SignUpActivity): Context

    @Binds
    @ActivityScope
    abstract fun provideActivity(signUpActivity: SignUpActivity): DaggerAppCompatActivity
}