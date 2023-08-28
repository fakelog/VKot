package ru.fakelog.vkot.core.data.tokens.repository

import ru.fakelog.vkot.core.data.data_source.local.db.AppDatabase
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenEntity
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenLocalDataSource
import ru.fakelog.vkot.core.data.tokens.data_source.remote.TokenRemoteDataSource
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val localDataSource: TokenLocalDataSource,
    private val remoteDataSource: TokenRemoteDataSource
) : TokenRepository {

    override suspend fun getToken(request: HashMap<String, Any>) = remoteDataSource.getToken(request)

    override suspend fun getAllLocalTokens() = localDataSource.getAllTokens()

    override suspend fun saveTokenToLocal(token: TokenEntity) = db.tokenDao().insert(token)
}