package ru.fakelog.vkot.core.domain.token.use_case

import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.domain.token.entity.model.Token
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import javax.inject.Inject

class SaveTokenToLocalUseCase @Inject constructor(
    private val repository: TokenRepository
) {

    suspend operator fun invoke(token: Token) {
        val tokenEntity = TokenEntity(
            token.accessToken,
            token.expiresIn,
            token.userId
        )

        repository.saveTokenToLocal(tokenEntity)
    }
}