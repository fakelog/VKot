package ru.fakelog.vkot.core.domain.auth.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.domain.token.entity.request.TokenValidationException
import ru.fakelog.vkot.core.domain.token.use_case.TokenUseCase
import ru.fakelog.vkot.core.domain.utils.Result
import kotlin.jvm.Throws

class IsLoggedInUseCase(
    private val tokenUseCase: TokenUseCase
) {

    @Throws(TokenValidationException::class)
    operator fun invoke(): Flow<Result<List<TokenEntity>>> = flow {
        emit(Result.Loading)

        val result = tokenUseCase.getAllLocalTokens()

        emit(result)
    }.flowOn(Dispatchers.IO)
}