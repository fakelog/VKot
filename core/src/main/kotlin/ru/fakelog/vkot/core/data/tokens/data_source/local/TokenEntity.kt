package ru.fakelog.vkot.core.data.tokens.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tokens", primaryKeys = ["user_id"])
class TokenEntity (

    @ColumnInfo(name = "access_token")
    val accessToken: String,

    @ColumnInfo(name = "expires_in")
    val expiresIn: Long,

    @ColumnInfo(name = "user_id")
    val userId: Long,
)