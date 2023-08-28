package ru.fakelog.vkot.core.domain.token.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenRequest(
    @SerialName("grant_type") val grantType: String,
    @SerialName("client_id") val clientId: Int,
    @SerialName("client_secret") val clientSecret: String,
    @SerialName("username") var username: String,
    @SerialName("password") var password: String,
    @SerialName("scope") val scope: Int,
    @SerialName("v") val apiVersion: String
) {
    constructor(): this(
        "password",
        2274003,
        "hHbZxrka2uZ6jB1inYsH",
        "",
        "",
        501202911,
        "5.131"
    )

    fun toMap(): HashMap<String, Any> {
        return hashMapOf(
            "grant_type" to grantType,
            "client_id" to clientId,
            "client_secret" to clientSecret,
            "username" to username,
            "password" to password,
            "scope" to scope,
            "v" to apiVersion
        )
    }
}

class TokenValidationException(private val validationType: String) : Exception(validationType)