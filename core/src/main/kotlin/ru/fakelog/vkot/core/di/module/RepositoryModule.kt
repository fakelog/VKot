package ru.fakelog.vkot.core.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fakelog.vkot.core.data.data_source.local.db.AppDatabase
import ru.fakelog.vkot.core.data.tokens.data_source.local.TokenLocalDataSource
import ru.fakelog.vkot.core.data.tokens.data_source.remote.TokenRemoteDataSource
import ru.fakelog.vkot.core.data.tokens.repository.TokenRepositoryImpl
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTokenRepository(
        db: AppDatabase,
        localDataSource: TokenLocalDataSource,
        remoteDataSource: TokenRemoteDataSource
    ): TokenRepository = TokenRepositoryImpl(db, localDataSource, remoteDataSource)
}