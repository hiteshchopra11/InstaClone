package com.hiteshchopra.data.remote

import android.util.Log
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
            Log.e("safeApiCall", throwable.message.toString())
            when (throwable) {
                is IOException -> ApiSafeResult.NetworkError
                is HttpException -> ApiSafeResult.Failure(throwable)
                else -> ApiSafeResult.Failure(Exception(throwable))
            }
        }
    }
}
