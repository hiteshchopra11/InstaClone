package com.hiteshchopra.instagramclone.ui.login

import android.content.Context
import android.util.Log
import com.hiteshchopra.instagramclone.di.module.BaseActivityModule
import com.hiteshchopra.instagramclone.di.qualifier.ActivityContext
import com.hiteshchopra.instagramclone.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class LoginActivityModule {

}