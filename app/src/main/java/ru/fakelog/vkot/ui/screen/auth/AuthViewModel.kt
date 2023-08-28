package ru.fakelog.vkot.ui.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.domain.accounts.use_case.LoadAllAccountsUseCase
import ru.fakelog.vkot.core.domain.auth.entity.enums.AuthButton
import ru.fakelog.vkot.core.domain.utils.Result
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loadAllAccountsUseCase: LoadAllAccountsUseCase
) : ViewModel() {

    private val _accountsList = MutableStateFlow<List<AccountEntity?>>(emptyList())
    private val _clickedButton = MutableStateFlow(AuthButton.NOT_ACTIVE)
    private val _showBottomSheet = MutableStateFlow(false)

    val accountsList: StateFlow<List<AccountEntity?>> = _accountsList
    val allAccountsState = MutableStateFlow<Result<List<AccountEntity?>>>(Result.Loading)
    val clickedButton: StateFlow<AuthButton> = _clickedButton
    val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

    init {
        checkedAllAccounts()
    }

    fun checkedAllAccounts() {
        viewModelScope.launch {
            loadAllAccountsUseCase()
                .collect {
                    when (it) {
                        Result.Default -> allAccountsState.value = Result.Default
                        is Result.Failure -> allAccountsState.value =
                            Result.Failure(it.failureStatus, it.code, it.message)

                        Result.Loading -> allAccountsState.value = Result.Loading
                        is Result.Success -> {
                            _accountsList.value = it.value
                            allAccountsState.value = it
                        }
                    }
                }
        }
    }

    fun setClickedButton(value: AuthButton) {
        _clickedButton.value = value
    }

    fun setShowBottomSheet(value: Boolean) {
        _showBottomSheet.value = value
    }
}