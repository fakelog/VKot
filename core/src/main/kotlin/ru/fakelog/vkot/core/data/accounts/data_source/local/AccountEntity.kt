package ru.fakelog.vkot.core.data.accounts.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "accounts", primaryKeys = ["user_id"])
class AccountEntity (

    @ColumnInfo(name = "is_active")
    val isActive: Boolean? = false,

    @ColumnInfo(name = "last_used")
    val lastUsed: Long? = null,

    @ColumnInfo(name = "user_id")
    val userId: Long
)