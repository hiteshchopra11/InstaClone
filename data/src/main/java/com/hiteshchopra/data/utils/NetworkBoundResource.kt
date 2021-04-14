package com.hiteshchopra.data.utils

import com.hiteshchopra.data.ApiSafeResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) =
    flow<ApiSafeResult<ResultType>> {
        val data = query().first()
        val flow = if (shouldFetch(data)) {
            try {
                saveFetchResult(fetch())
                query().map { ApiSafeResult.Success(it) }
            } catch (throwable: Throwable) {
                query().map { ApiSafeResult.Failure() }
            }
        } else {
            query().map { ApiSafeResult.Success(it) }
        }
        emitAll(flow)
    }
