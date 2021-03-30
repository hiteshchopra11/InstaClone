package com.hiteshchopra.data

import com.google.firebase.auth.FirebaseUser

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class FirebaseSafeResult<out T> {
    data class Success<T>(val result: FirebaseUser) : FirebaseSafeResult<T>()
    data class Failure(
        val exception: Exception? = Exception("Unknown Error"),
        val message: String = exception?.message ?: ""
    ) : FirebaseSafeResult<Nothing>()

    object NetworkError : FirebaseSafeResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$result]"
            is Failure -> "Failure[exception=$exception]"
            is NetworkError -> "NetworkError"
        }
    }
}