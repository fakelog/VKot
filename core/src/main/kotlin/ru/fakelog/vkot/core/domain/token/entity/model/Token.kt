package ru.fakelog.vkot.core.domain.token.entity.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
    @SerialName("access_token")
    var accessToken: String,

    @SerialName("expires_in")
    var expiresIn: Long,

    @SerialName("user_id")
    var userId: Long,

    @SerialName("email")
    var email: String
)