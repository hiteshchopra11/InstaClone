package com.hiteshchopra.data

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ApiSafeResult<out T> {

    data class Success<T>(val data: T) : ApiSafeResult<T>()
    data class Failure(
        val exception: Exception? = Exception("Unknown Error"),
        val message: String = exception?.localizedMessage ?: ""
    ) : ApiSafeResult<Nothing>()

    object NetworkError : ApiSafeResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Failure -> "Failure[exception=$exception]"
            is NetworkError -> "NetworkError"
            else ->  "NetworkError"
        }
    }
}

/**
 * `true` if [SafeResult] is of type [Success] & holds non-null [Success.data].
 */
val ApiSafeResult<*>.succeeded
    get() = this is ApiSafeResult.Success && data != null

fun <T> ApiSafeResult<T>.getSuccessOrNull(): T? {
    return when (this) {
        is ApiSafeResult.Success -> this.data
        else -> null
    }
}

fun <T> ApiSafeResult<T>.getErrorOrNull(): ApiSafeResult.Failure? {
    return when (this) {
        is ApiSafeResult.Failure -> this
        else -> null
    }
}