package ru.fakelog.vkot.core.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fakelog.vkot.core.domain.auth.use_case.IsLoggedInUseCase
import ru.fakelog.vkot.core.domain.auth.use_case.LoginUseCase
import ru.fakelog.vkot.core.domain.token.use_case.TokenUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideIsLoggedInUseCase(tokenUseCase: TokenUseCase): IsLoggedInUseCase = IsLoggedInUseCase(tokenUseCase)

    @Provides
    @Singleton
    fun provideLoginUseCase(tokenUseCase: TokenUseCase): LoginUseCase = LoginUseCase(tokenUseCase)
}