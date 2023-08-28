package ru.fakelog.vkot.core.data.tokens.data_source.local

import ru.fakelog.vkot.core.data.data_source.local.db.AppDatabase
import ru.fakelog.vkot.core.data.data_source.local.db.BaseLocalDataSource
import javax.inject.Inject

class TokenLocalDataSource @Inject constructor(private val db: AppDatabase): BaseLocalDataSource() {

    suspend fun getAllTokens() = safeDbCall {
        db.tokenDao().getAllTokens()
    }

}