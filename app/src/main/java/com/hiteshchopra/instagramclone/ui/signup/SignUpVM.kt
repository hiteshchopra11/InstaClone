package com.hiteshchopra.instagramclone.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.SafeResult
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.domain.usecase.UseCaseFirebaseSignUp
import com.hiteshchopra.instagramclone.ui.base.BaseVM
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpVM @Inject constructor(
    private val useCaseFirebaseSignUp: UseCaseFirebaseSignUp
) : BaseVM() {

    private var _viewState: MutableLiveData<SignUpViewState> = MutableLiveData()
    val viewState: LiveData<SignUpViewState> = _viewState

    fun firebaseSignUp(user: User) {
        _viewState.value = SignUpViewState.Loading
        viewModelScope.launch {
            when (val result = useCaseFirebaseSignUp.perform(user)) {
                is SafeResult.Success -> {
                    _viewState.value = SignUpViewState.Success
                }
                is SafeResult.Failure -> {
                    _viewState.value = SignUpViewState.Error(result.exception)
                }
            }
        }
    }
}

sealed class SignUpViewState {
    object Loading : SignUpViewState()
    class Error(val error: Exception?) : SignUpViewState()
    object Success : SignUpViewState()
}
