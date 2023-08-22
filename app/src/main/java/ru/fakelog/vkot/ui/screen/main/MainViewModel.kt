package ru.fakelog.vkot.ui.screen.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _showStatusIndicator = mutableStateOf(false)

    val showStatusIndicator: State<Boolean> get() = _showStatusIndicator

    fun setShowStatusIndicator(value: Boolean) {
        _showStatusIndicator.value = value
    }
}