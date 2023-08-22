package ru.fakelog.vkot.data.auth.repository

import ru.fakelog.vkot.data.auth.data_source.remote.AuthRemoteDataSource
import ru.fakelog.vkot.domain.auth.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun getToken(request: HashMap<String, Any>) = remoteDataSource.getToken(request)
}