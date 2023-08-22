package ru.fakelog.vkot.domain.auth.enums

enum class AuthFieldsValidation(val value: Int) {
    EMPTY_USERNAME(1),
    EMPTY_PASSWORD(2)
}