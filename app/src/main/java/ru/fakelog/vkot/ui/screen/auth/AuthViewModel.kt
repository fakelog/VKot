package ru.fakelog.vkot.ui.screen.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    private val _showBottomSheet = mutableStateOf(false)
    private val _showStatusIndicator = mutableStateOf(false)

    val showBottomSheet: State<Boolean> get() = _showBottomSheet
    val showStatusIndicator: State<Boolean> get() = _showStatusIndicator

    fun setShowBottomSheet(value: Boolean) {
        _showBottomSheet.value = value
    }

    fun setShowStatusIndicator(value: Boolean) {
        _showStatusIndicator.value = value
    }
}