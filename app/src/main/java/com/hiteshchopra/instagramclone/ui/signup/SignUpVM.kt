package com.hiteshchopra.instagramclone.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.FirebaseSafeResult
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.domain.usecase.UseCaseFirebaseSignUp
import com.hiteshchopra.instagramclone.ui.base.BaseVM
import com.hiteshchopra.instagramclone.utils.Validity.isInvalidEmail
import com.hiteshchopra.instagramclone.utils.Validity.isShortPassword
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpVM @Inject constructor(
    private val useCaseFirebaseSignUp: UseCaseFirebaseSignUp
) : BaseVM() {

    private var _signUpState: MutableLiveData<SignUpViewState> = MutableLiveData()
    val signUpState: LiveData<SignUpViewState> = _signUpState

    private var _validateState: MutableLiveData<SignUpValidateState> = MutableLiveData()
    var validateState: LiveData<SignUpValidateState> = _validateState

    fun validateEmailPassword(email: String, password: String) {
        when {
            email.isEmpty() ->
                _validateState.value = SignUpValidateState.EmptyEmail
            password.isEmpty() ->
                _validateState.value = SignUpValidateState.EmptyPassword
            email.isInvalidEmail() ->
                _validateState.value = SignUpValidateState.InvalidEmail
            password.isShortPassword() ->
                _validateState.value = SignUpValidateState.ShortPassword
            else ->
                _validateState.value = SignUpValidateState.Valid
        }
    }

    fun firebaseSignUp(email: String, password: String) {
        val user = User(email, password)
        _signUpState.value = SignUpViewState.Loading
        viewModelScope.launch {
            when (val result = useCaseFirebaseSignUp.perform(user)) {
                is FirebaseSafeResult.Success -> {
                    _signUpState.value = SignUpViewState.Success
                }
                is FirebaseSafeResult.Failure -> {
                    _signUpState.value = SignUpViewState.Error(result.exception)
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

sealed class SignUpValidateState {
    object EmptyEmail : SignUpValidateState()
    object EmptyPassword : SignUpValidateState()
    object InvalidEmail : SignUpValidateState()
    object ShortPassword : SignUpValidateState()
    object Valid : SignUpValidateState()
}
