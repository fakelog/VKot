package ru.fakelog.vkot.core.domain.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(

    @SerialName("captcha_sid")
    val captchaSid: String? = null,

    @SerialName("captcha_image")
    val captchaImage: String? = null,

    @SerialName("error")
    val error: String? = null,

    @SerialName("error_code")
    val code: Int? = null,

    @SerialName("error_description")
    val description: String? = null,

    @SerialName("error_msg")
    val message: String? = null,

    @SerialName("error_type")
    val type: String? = null
)
