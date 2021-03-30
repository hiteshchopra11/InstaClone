package com.hiteshchopra.data

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class SafeResult<out T> {
    data class Success<T>(val result: FirebaseUser) : SafeResult<T>()
    data class Failure(
        val exception: Exception? = Exception("Unknown Error"),
        val message: String = exception?.message ?: ""
    ) : SafeResult<Nothing>()

    object NetworkError : SafeResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$result]"
            is Failure -> "Failure[exception=$exception]"
            is NetworkError -> "NetworkError"
        }
    }
}