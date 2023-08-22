package ru.fakelog.vkot.domain.utils

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val error: String,
    val error_description: String,
    val error_type: String?
)