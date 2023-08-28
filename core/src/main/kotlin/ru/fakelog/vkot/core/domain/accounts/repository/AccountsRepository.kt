package ru.fakelog.vkot.core.domain.accounts.repository

import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.domain.utils.Result

interface AccountsRepository {

    suspend fun getActiveLocalAccount(): Result<AccountEntity?>

    suspend fun getAllLocalAccounts(): Result<List<AccountEntity?>>

    suspend fun saveAccountToLocal(account: AccountEntity): Result<Long>
}