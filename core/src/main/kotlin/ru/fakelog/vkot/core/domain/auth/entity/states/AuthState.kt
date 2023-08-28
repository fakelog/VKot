package ru.fakelog.vkot.core.domain.auth.entity.states

import ru.fakelog.vkot.core.domain.utils.FailureStatus

sealed class AuthState {
    object Default : AuthState()
    data class Failure(val failureStatus: FailureStatus, val message: String? = null) : AuthState()
    object Loading : AuthState()
    object Success : AuthState()
}
