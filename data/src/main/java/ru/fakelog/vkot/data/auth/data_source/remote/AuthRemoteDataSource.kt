package ru.fakelog.vkot.data.auth.data_source.remote

import ru.fakelog.vkot.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(private val apiService: AuthService): BaseRemoteDataSource() {

    suspend fun getToken(request: HashMap<String, Any>) = safeApiCall {
        apiService.getToken(request)
    }
}