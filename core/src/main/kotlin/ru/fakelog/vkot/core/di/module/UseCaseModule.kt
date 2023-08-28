package ru.fakelog.vkot.core.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fakelog.vkot.core.domain.accounts.use_case.AccountsUseCase
import ru.fakelog.vkot.core.domain.auth.use_case.IsLoggedInUseCase
import ru.fakelog.vkot.core.domain.auth.use_case.LoginUseCase
import ru.fakelog.vkot.core.domain.token.repository.TokenRepository
import ru.fakelog.vkot.core.domain.token.use_case.GetActiveAccountTokenUseCase
import ru.fakelog.vkot.core.domain.token.use_case.TokenUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetLastUsedTokenUseCase(
        accountsUseCase: AccountsUseCase,
        repository: TokenRepository
    ): GetActiveAccountTokenUseCase = GetActiveAccountTokenUseCase(accountsUseCase, repository)

    @Provides
    @Singleton
    fun provideIsLoggedInUseCase(
        accountsUseCase: AccountsUseCase
    ): IsLoggedInUseCase = IsLoggedInUseCase(accountsUseCase)

    @Provides
    @Singleton
    fun provideLoginUseCase(
        accountsUseCase: AccountsUseCase,
        tokenUseCase: TokenUseCase
    ):LoginUseCase = LoginUseCase(accountsUseCase, tokenUseCase)
}