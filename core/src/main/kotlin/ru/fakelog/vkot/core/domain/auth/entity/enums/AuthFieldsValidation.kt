package ru.fakelog.vkot.core.domain.auth.entity.enums

enum class AuthFieldsValidation(val value: Int) {
    EMPTY_USERNAME(1),
    EMPTY_PASSWORD(2)
}