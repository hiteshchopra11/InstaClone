package com.hiteshchopra.instagramclone.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.SafeResult
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.domain.usecase.UseCaseFirebaseLogin
import com.hiteshchopra.instagramclone.ui.base.BaseVM
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class LoginVM @Inject constructor(
    private val useCaseFirebaseLogin: UseCaseFirebaseLogin
) : BaseVM() {

    private var _viewState: MutableLiveData<SignInViewState> = MutableLiveData()
    val viewState: LiveData<SignInViewState> = _viewState

    fun firebaseSignIn(user: User) {
        _viewState.value = SignInViewState.Loading
        viewModelScope.launch {
            when (val result = useCaseFirebaseLogin.perform(user)) {
                is SafeResult.Success -> {
                    _viewState.value = SignInViewState.Success
                }
                is SafeResult.Failure -> {
                    Timber.e("onError")
                    _viewState.value = SignInViewState.Error(result.exception)
                }
            }
        }
    }
}


sealed class SignInViewState {
    object Loading : SignInViewState()
    class Error(val error: Exception?) : SignInViewState()
    object Success : SignInViewState()
}