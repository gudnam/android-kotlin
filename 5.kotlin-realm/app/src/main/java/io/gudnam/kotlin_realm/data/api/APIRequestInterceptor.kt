package io.gudnam.kotlin_realm.data.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by gudnam on 2017. 5. 11..
 */
class APIRequestInterceptor(val accessToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url().newBuilder().build()
        var newRequest = request.newBuilder()
                .url(url)
                .addHeader("Authorization", "Bearer $accessToken")
                .build()

        return chain.proceed(newRequest)
    }
}