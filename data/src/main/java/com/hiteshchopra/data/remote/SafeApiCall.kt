package com.hiteshchopra.data.remote

import com.hiteshchopra.data.ApiSafeResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

internal suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ApiSafeResult<T> {
    return withContext(dispatcher) {
        try {
            ApiSafeResult.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ApiSafeResult.NetworkError
                is HttpException -> ApiSafeResult.Failure(null, throwable)
                else -> ApiSafeResult.Failure(null, Exception(throwable))
            }
        }
    }
}
