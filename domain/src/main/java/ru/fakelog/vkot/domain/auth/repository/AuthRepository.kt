package ru.fakelog.vkot.domain.auth.repository

import ru.fakelog.vkot.domain.auth.entity.model.Token
import ru.fakelog.vkot.domain.utils.BaseResponse
import ru.fakelog.vkot.domain.utils.Resource

interface AuthRepository {

    suspend fun getToken(request: HashMap<String, Any>): Resource<BaseResponse<Token>>
}