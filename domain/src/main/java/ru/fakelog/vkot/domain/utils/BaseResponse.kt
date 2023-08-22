package ru.fakelog.vkot.domain.utils

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val result: T,
    val detail: String
)