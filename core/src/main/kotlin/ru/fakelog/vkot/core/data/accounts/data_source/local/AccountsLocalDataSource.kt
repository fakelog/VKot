package ru.fakelog.vkot.core.data.accounts.data_source.local

import ru.fakelog.vkot.core.data.data_source.local.db.AppDatabase
import ru.fakelog.vkot.core.data.data_source.local.db.BaseLocalDataSource
import javax.inject.Inject

class AccountsLocalDataSource @Inject constructor(private val db: AppDatabase): BaseLocalDataSource() {

    suspend fun getActiveAccount() = safeDbCall { db.accountsDao().getActiveAccount() }

    suspend fun getAllAccounts() = safeDbCall { db.accountsDao().getAllAccounts() }
    suspend fun saveAccount(account: AccountEntity) = safeDbCall { db.accountsDao().insert(account) }
}