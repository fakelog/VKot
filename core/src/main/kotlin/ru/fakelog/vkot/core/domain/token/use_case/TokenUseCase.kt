package ru.fakelog.vkot.core.domain.token.use_case

import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.domain.token.entity.model.Token
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import javax.inject.Inject

class TokenUseCase @Inject constructor(
    private val repository: TokenRepository,
    private val saveTokenToLocalUseCase: SaveTokenToLocalUseCase
) {

    suspend fun getAllLocalTokens() = repository.getAllLocalTokens()

    suspend fun getToken(request: HashMap<String, Any>) = repository.getToken(request)

    suspend fun saveTokenToLocal(token: Token) = saveTokenToLocalUseCase(token)
}