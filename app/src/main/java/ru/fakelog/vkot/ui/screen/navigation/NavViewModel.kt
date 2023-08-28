package ru.fakelog.vkot.ui.screen.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import ru.fakelog.vkot.core.domain.auth.entity.states.AuthState
import ru.fakelog.vkot.core.domain.auth.use_case.IsLoggedInUseCase
import ru.fakelog.vkot.core.domain.utils.FailureStatus
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(
    private val isLoggedInUseCase: IsLoggedInUseCase
): ViewModel() {

    val loggedInState = MutableStateFlow<AuthState>(AuthState.Loading)

    init {
        checkLoggedInState()
    }

    private fun checkLoggedInState() {
        viewModelScope.launch {
            isLoggedInUseCase()
                .catch { exception ->
                    loggedInState.value = AuthState.Failure(FailureStatus.OTHER, exception.message)
                }
                .collect { result ->
                    when (result) {
                        is Result.Default -> loggedInState.value = AuthState.Default
                        is Result.Failure -> {
                            when (result.failureStatus) {
                                FailureStatus.EMPTY -> loggedInState.value = AuthState.Default
                                else -> loggedInState.value = AuthState.Failure(result.failureStatus, result.message)
                            }

                        }
                        is Result.Loading -> loggedInState.value = AuthState.Loading
                        is Result.Success -> loggedInState.value = AuthState.Success
                    }
                }
        }
    }
}