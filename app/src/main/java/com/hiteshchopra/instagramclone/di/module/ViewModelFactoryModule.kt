package com.hiteshchopra.instagramclone.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hiteshchopra.instagramclone.di.scope.ViewModelKey
import com.hiteshchopra.instagramclone.ui.home.HomeVM
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.HomeScreenVM
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.SearchFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.SearchFragmentVM
import com.hiteshchopra.instagramclone.ui.login.LoginVM
import com.hiteshchopra.instagramclone.ui.signup.SignUpVM
import com.hiteshchopra.instagramclone.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginVM::class)
    abstract fun bindLoginVM(loginVM: LoginVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpVM::class)
    abstract fun bindSignUpVM(signUpVM: SignUpVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeVM::class)
    abstract fun bindHomeVM(homeScreenVM: HomeVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenVM::class)
    abstract fun bindHomeScreenVM(homeScreenVM: HomeScreenVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchFragmentVM::class)
    abstract fun bindSearchFragmentVM(searchScreenVM: SearchFragmentVM): ViewModel
}