package ru.fakelog.vkot.core.data.tokens.data_source.remote

import retrofit2.http.GET
import retrofit2.http.QueryMap
import ru.fakelog.vkot.core.domain.token.entity.model.Token

interface TokenServices {

    @GET("token")
    suspend fun getToken(@QueryMap request: HashMap<String, Any>): Token
}