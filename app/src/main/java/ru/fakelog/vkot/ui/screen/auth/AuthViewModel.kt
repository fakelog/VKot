package ru.fakelog.vkot.ui.screen.auth

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.fakelog.vkot.domain.auth.enums.AuthButton
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _clickedButton = MutableStateFlow(AuthButton.NOT_ACTIVE)
    private val _showBottomSheet = MutableStateFlow(false)

    val clickedButton: StateFlow<AuthButton> = _clickedButton
    val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

    fun setClickedButton(value: AuthButton) {
        _clickedButton.value = value

    }

    fun setShowBottomSheet(value: Boolean) {
        _showBottomSheet.value = value
    }
}