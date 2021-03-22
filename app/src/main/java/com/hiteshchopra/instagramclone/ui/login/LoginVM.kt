package com.hiteshchopra.instagramclone.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.SafeResult
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.domain.usecase.UseCaseFirebaseLogin
import com.hiteshchopra.instagramclone.ui.base.BaseVM
import com.hiteshchopra.instagramclone.utils.Validity.isInvalidEmail
import com.hiteshchopra.instagramclone.utils.Validity.isShortPassword
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginVM @Inject constructor(
    private val useCaseFirebaseLogin: UseCaseFirebaseLogin
) : BaseVM() {

    private var _loginState: MutableLiveData<LoginViewState> = MutableLiveData()
    val loginState: LiveData<LoginViewState> = _loginState

    private var _validateState: MutableLiveData<SignInValidateState> = MutableLiveData()
    val validateState: LiveData<SignInValidateState> = _validateState

    fun validateEmailPassword(email: String, password: String) {
        when {
            email.isEmpty() ->
                _validateState.value = SignInValidateState.EmptyEmail
            password.isEmpty() ->
                _validateState.value = SignInValidateState.EmptyPassword
            email.isInvalidEmail() ->
                _validateState.value = SignInValidateState.InvalidEmail
            password.isShortPassword() ->
                _validateState.value = SignInValidateState.ShortPassword
            else ->
                _validateState.value = SignInValidateState.Valid
        }
    }

    fun firebaseSignUp(email: String, password: String) {
        val user = User(email, password)
        _loginState.value = LoginViewState.Loading
        viewModelScope.launch {
            when (val result = useCaseFirebaseLogin.perform(user)) {
                is SafeResult.Success -> {
                    _loginState.value = LoginViewState.Success
                }
                is SafeResult.Failure -> {
                    _loginState.value = LoginViewState.Error(result.exception)
                }
            }
        }
    }
}

sealed class LoginViewState {
    object Loading : LoginViewState()
    class Error(val error: Exception?) : LoginViewState()
    object Success : LoginViewState()
}

sealed class SignInValidateState {
    object EmptyEmail : SignInValidateState()
    object EmptyPassword : SignInValidateState()
    object InvalidEmail : SignInValidateState()
    object ShortPassword : SignInValidateState()
    object Valid : SignInValidateState()
}