package ru.fakelog.vkot.core.domain.utils

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse2<T>(
    val result: T,
    val detail: String
)