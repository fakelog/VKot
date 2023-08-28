package ru.fakelog.vkot.core.data.tokens.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TokenDao {

    @Query("SELECT * FROM tokens")
    suspend fun getAllTokens(): List<TokenEntity>

    @Query("SELECT * FROM tokens WHERE user_id = :userId")
    suspend fun getTokenByUserId(userId: Long): TokenEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(token: TokenEntity)
}