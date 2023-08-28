package ru.fakelog.vkot.core.domain.token.use_case

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.domain.accounts.use_case.AccountsUseCase
import ru.fakelog.vkot.core.domain.token.entity.request.TokenValidationException
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import ru.fakelog.vkot.core.domain.utils.FailureStatus
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject
import kotlin.jvm.Throws


class GetActiveAccountTokenUseCase @Inject constructor(
    private val accountsUseCase: AccountsUseCase,
    private val repository: TokenRepository
) {

    @Throws(TokenValidationException::class)
    operator fun invoke(): Flow<Result<TokenEntity>> = flow {
        emit(Result.Loading)

        val lastUsedAccount = accountsUseCase.getActiveLocalAccount()
        val result: Result<TokenEntity> = when (lastUsedAccount) {
            is Result.Failure -> lastUsedAccount
            is Result.Success -> {
                Result.Failure(FailureStatus.OTHER)
            }
            else -> Result.Default
        }

        Log.d("dfaa", lastUsedAccount.toString())

        emit(result)
    }.flowOn(Dispatchers.IO)
}