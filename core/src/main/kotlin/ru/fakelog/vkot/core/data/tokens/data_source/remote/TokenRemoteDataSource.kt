package ru.fakelog.vkot.core.data.tokens.data_source.remote

import ru.fakelog.vkot.core.data.data_source.remote.BaseRemoteDataSource
import javax.inject.Inject

class TokenRemoteDataSource @Inject constructor(private val tokenService: TokenServices): BaseRemoteDataSource() {

    suspend fun getToken(request: HashMap<String, Any>) = safeApiCall {
        tokenService.getToken(request)
    }
}