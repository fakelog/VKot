package ru.fakelog.vkot.core.domain.token.repository

import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.domain.token.entity.model.Token
import ru.fakelog.vkot.core.domain.utils.Result

interface TokenRepository {

    suspend fun getAllLocalTokens(): Result<List<TokenEntity>>

    suspend fun getLocalTokenByUserId(userId: Long): Result<TokenEntity>

    suspend fun getRemoteToken(request: HashMap<String, Any>): Result<Token>

    suspend fun saveTokenToLocal(token: TokenEntity)
}