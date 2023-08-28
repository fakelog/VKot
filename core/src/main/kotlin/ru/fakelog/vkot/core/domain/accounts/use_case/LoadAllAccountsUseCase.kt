package ru.fakelog.vkot.core.domain.accounts.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.domain.accounts.repository.AccountsRepository
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject

class LoadAllAccountsUseCase @Inject constructor(
    private val repository: AccountsRepository
) {

    operator fun invoke(): Flow<Result<List<AccountEntity?>>> = flow {
        emit(Result.Loading)

        when(val accounts = repository.getAllLocalAccounts()){
            Result.Default -> emit(Result.Default)
            is Result.Failure -> emit(accounts)
            Result.Loading -> emit(Result.Loading)
            is Result.Success -> emit(accounts)
        }
    }
}