package com.treemiddle.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class PokeRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()

        return chain.proceed(request)
    }
}
