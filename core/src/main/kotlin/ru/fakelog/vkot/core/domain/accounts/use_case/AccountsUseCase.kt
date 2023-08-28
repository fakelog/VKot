package ru.fakelog.vkot.core.domain.accounts.use_case

import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.domain.accounts.repository.AccountsRepository
import javax.inject.Inject

class AccountsUseCase @Inject constructor(
    private val repository: AccountsRepository
) {

    suspend fun getActiveLocalAccount() = repository.getActiveLocalAccount()

    suspend fun getAllLocalAccounts() = repository.getAllLocalAccounts()

    suspend fun saveAccountToLocal(account: AccountEntity) = repository.saveAccountToLocal(account)
}