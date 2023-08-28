package ru.fakelog.vkot.core.data.accounts.repository

import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountsLocalDataSource
import ru.fakelog.vkot.core.domain.accounts.repository.AccountsRepository
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val localDataSource: AccountsLocalDataSource
): AccountsRepository {

    override suspend fun getActiveLocalAccount() = localDataSource.getActiveAccount()

    override suspend fun getAllLocalAccounts() = localDataSource.getAllAccounts()

    override suspend fun saveAccountToLocal(account: AccountEntity) = localDataSource.saveAccount(account)
}