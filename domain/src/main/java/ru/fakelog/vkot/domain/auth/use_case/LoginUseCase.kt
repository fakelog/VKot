package ru.fakelog.vkot.domain.auth.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.fakelog.vkot.domain.auth.entity.model.Token
import ru.fakelog.vkot.domain.auth.entity.request.TokenRequest
import ru.fakelog.vkot.domain.auth.entity.request.TokenValidationException
import ru.fakelog.vkot.domain.auth.enums.AuthFieldsValidation
import ru.fakelog.vkot.domain.auth.repository.AuthRepository
import ru.fakelog.vkot.domain.utils.BaseResponse
import ru.fakelog.vkot.domain.utils.Resource
import javax.inject.Inject
import kotlin.jvm.Throws


class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {

    @Throws(TokenValidationException::class)
    operator fun invoke(request: TokenRequest): Flow<Resource<BaseResponse<Token>>> = flow {
        if (request.username.isEmpty()) {
            throw TokenValidationException(AuthFieldsValidation.EMPTY_USERNAME.value.toString())
        }

        if (request.password.isEmpty()) {
            throw TokenValidationException(AuthFieldsValidation.EMPTY_PASSWORD.value.toString())
        }

        emit(Resource.Loading)

        val result = authRepository.getToken(request.toMap())
        if (result is Resource.Success) {
            // Сохранение токена
        }

        emit(result)
    }.flowOn(Dispatchers.IO)
}