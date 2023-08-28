package ru.fakelog.vkot.core.domain.auth.use_case

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import ru.fakelog.vkot.core.domain.accounts.use_case.AccountsUseCase
import ru.fakelog.vkot.core.domain.token.entity.request.TokenValidationException
import ru.fakelog.vkot.core.domain.token.use_case.TokenUseCase
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject
import kotlin.jvm.Throws

class IsLoggedInUseCase @Inject constructor(
    private val accountsUseCase: AccountsUseCase
) {

    @Throws(TokenValidationException::class)
    operator fun invoke(): Flow<Result<Boolean>> = flow {
        emit(Result.Loading)

        val result = when (val activeAccount = accountsUseCase.getActiveLocalAccount()) {
            is Result.Failure -> activeAccount
            is Result.Success -> Result.Success(true)
            else -> Result.Success(false)
        }

        emit(result)
    }.flowOn(Dispatchers.IO)
}