package ru.fakelog.vkot.domain.auth.entity.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
    @SerialName("access_token")
    var accessToken: String,
    @SerialName("expires_in")
    var expiresIn: Int,
    @SerialName("user_id")
    var userId: Int
)