package ru.fakelog.vkot.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fakelog.vkot.data.auth.data_source.remote.AuthRemoteDataSource
import ru.fakelog.vkot.data.auth.repository.AuthRepositoryImpl
import ru.fakelog.vkot.domain.auth.repository.AuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        remoteDataSource: AuthRemoteDataSource
    ): AuthRepository = AuthRepositoryImpl(remoteDataSource)
}