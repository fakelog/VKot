package ru.fakelog.vkot.core.data.accounts.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "accounts")
class AccountEntity (

    @ColumnInfo(name = "id")
    val userId: Long,

    @ColumnInfo(name = "token_id")
    val tokenId: Long,

    @ColumnInfo(name = "last_used")
    val lastUsed: Long? = null
)