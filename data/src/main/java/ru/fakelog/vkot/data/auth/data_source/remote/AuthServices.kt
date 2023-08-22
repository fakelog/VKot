package ru.fakelog.vkot.data.auth.data_source.remote

import retrofit2.http.GET
import retrofit2.http.QueryMap
import ru.fakelog.vkot.domain.auth.entity.model.Token
import ru.fakelog.vkot.domain.utils.BaseResponse

interface AuthService {
    @GET("token")
    suspend fun getToken(@QueryMap request: HashMap<String, Any>): BaseResponse<Token>
}