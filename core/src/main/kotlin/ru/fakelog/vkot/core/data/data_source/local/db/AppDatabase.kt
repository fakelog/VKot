package ru.fakelog.vkot.core.data.data_source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenDao

@Database(
    entities = [
        TokenEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {

    abstract fun tokenDao(): TokenDao
}