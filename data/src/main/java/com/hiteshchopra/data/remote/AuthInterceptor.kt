package com.hiteshchopra.data.remote

import com.hiteshchopra.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url.newBuilder().addQueryParameter("client_id", BuildConfig.SEARCH_API_KEY).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}