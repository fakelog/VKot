package ru.fakelog.vkot.core.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.fakelog.vkot.core.data.tokens.data_source.remote.TokenServices
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {

    @Provides
    @Singleton
    fun provideTokenServices(@Named("auth") retrofit: Retrofit): TokenServices =
        retrofit.create(TokenServices::class.java)
}