package ru.fakelog.vkot.core.domain.token.use_case

import kotlinx.coroutines.flow.Flow
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.domain.token.entity.model.Token
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject

class TokenUseCase @Inject constructor(
    private val repository: TokenRepository,
    private val getActiveAccountTokenUseCase: GetActiveAccountTokenUseCase,
    private val saveTokenToLocalUseCase: SaveTokenToLocalUseCase
) {

    suspend fun getAllLocalTokens() = repository.getAllLocalTokens()

    suspend fun getActiveAccountToken() = getActiveAccountTokenUseCase()

    suspend fun getToken(request: HashMap<String, Any>) = repository.getRemoteToken(request)

    suspend fun saveTokenToLocal(token: Token) = saveTokenToLocalUseCase(token)
}