package ru.fakelog.vkot.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import ru.fakelog.vkot.core.constants.ApiConstants

class VkInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.url.newBuilder()

        if (needParameters(request)) { builder
//            .addQueryParameter(ApiConstants.ACCESS_TOKEN)
            .addQueryParameter(ApiConstants.VERSION, ApiConstants.API_VERSION)
        }

        val url = builder.build()

        request = request.newBuilder()
            .url(url)
            .removeHeader(ApiConstants.NO_TOKEN_HEADER_KEY)
            .build()

        return chain.proceed(request)
    }

    private fun needParameters(request: Request) = request.header(ApiConstants.NO_TOKEN_HEADER_KEY).isNullOrEmpty()
}