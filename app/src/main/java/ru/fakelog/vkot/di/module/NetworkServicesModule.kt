package ru.fakelog.vkot.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.fakelog.vkot.data.auth.data_source.remote.AuthService
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkServicesModule {

    @Provides
    @Singleton
    fun provideAuthServices(@Named("auth") retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)
}