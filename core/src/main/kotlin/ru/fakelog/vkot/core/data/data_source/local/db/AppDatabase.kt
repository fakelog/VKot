package ru.fakelog.vkot.core.data.data_source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountsDao
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenDao

@Database(
    entities = [
        AccountEntity::class,
        TokenEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {

    abstract fun accountsDao(): AccountsDao

    abstract fun tokenDao(): TokenDao
}