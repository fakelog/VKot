package ru.fakelog.vkot.core.data.accounts.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AccountsDao {

    @Query("SELECT * FROM accounts WHERE is_active = 1 LIMIT 1")
    suspend fun getActiveAccount(): AccountEntity?

    @Query("SELECT * FROM accounts")
    suspend fun getAllAccounts(): List<AccountEntity?>

    @Query("SELECT * FROM accounts ORDER BY last_used")
    suspend fun getLastUsedAccounts(): List<AccountEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(account: AccountEntity): Long
}