package ru.fakelog.vkot.core.data.accounts.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity

@Dao
interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(token: TokenEntity)
}