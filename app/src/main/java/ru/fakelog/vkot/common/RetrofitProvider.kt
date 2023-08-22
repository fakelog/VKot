package ru.fakelog.vkot.common

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

fun retrofitProvider(json: Json, okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory(contentType))
        .baseUrl(baseUrl)
        .build()
}
