package ru.fakelog.vkot.core.domain.auth.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.fakelog.vkot.core.domain.token.entity.model.Token
import ru.fakelog.vkot.core.domain.token.entity.request.TokenRequest
import ru.fakelog.vkot.core.domain.token.entity.request.TokenValidationException
import ru.fakelog.vkot.core.domain.auth.entity.enums.AuthFieldsValidation
import ru.fakelog.vkot.core.domain.token.use_case.TokenUseCase
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject
import kotlin.jvm.Throws


class LoginUseCase @Inject constructor(
    private val tokenUseCase: TokenUseCase
) {
    @Throws(TokenValidationException::class)
    operator fun invoke(request: TokenRequest): Flow<Result<Token>> = flow {
        if (request.username.isEmpty()) {
            throw TokenValidationException(AuthFieldsValidation.EMPTY_USERNAME.value.toString())
        }

        if (request.password.isEmpty()) {
            throw TokenValidationException(AuthFieldsValidation.EMPTY_PASSWORD.value.toString())
        }

        emit(Result.Loading)

        val result = tokenUseCase.getToken(request.toMap())
        if (result is Result.Success) {
            tokenUseCase.saveTokenToLocal(result.value)
        }

        emit(result)
    }.flowOn(Dispatchers.IO)
}