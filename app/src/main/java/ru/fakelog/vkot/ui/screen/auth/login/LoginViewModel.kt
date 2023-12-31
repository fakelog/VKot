package ru.fakelog.vkot.ui.screen.auth.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.fakelog.vkot.core.domain.token.entity.request.TokenRequest
import ru.fakelog.vkot.core.domain.auth.use_case.LoginUseCase
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _loginMessage = MutableStateFlow<String?>("")
    private val _password = mutableStateOf("")
    private val _username = mutableStateOf("")
    private val _validationException = MutableStateFlow<Int?>(null)

    val loginMessage = _loginMessage
    val password: State<String> get() = _password
    val username: State<String> get() = _username
    fun setPassword(value: String) {
        _password.value = value
    }

    fun setUsername(value: String) {
        _username.value = value
    }

    fun onLoginClicked() {
        val request = TokenRequest()
        request.username = username.value
        request.password = password.value

        loginUseCase(request)
            .catch { exception ->
                _validationException.value = exception.message?.toInt()
                Log.e("_validationException", exception.message.toString())
            }
            .onEach { result ->
                when (result) {
                    is Result.Success -> {
                        val baseResponse = result.value
                        val actualResult = baseResponse.userId
                    }
                    is Result.Failure -> {
//                        val failureStatus = result.failureStatus
//                        val code = result.code
                        val message = result.message
                        _loginMessage.value = message.toString()
                    }
                    is Result.Loading -> {
                        Log.d("_loginResponse", "Loading...")
                    }
                    is Result.Default -> {
                        Log.d("_loginResponse", "Default")
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}