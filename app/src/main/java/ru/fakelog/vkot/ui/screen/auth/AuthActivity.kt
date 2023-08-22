package ru.fakelog.vkot.ui.screen.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.fakelog.vkot.ui.components.indicator.StatusIndicator
import ru.fakelog.vkot.ui.navigation.MainDestinations
import ru.fakelog.vkot.ui.navigation.VKotNavHost
import ru.fakelog.vkot.ui.theme.VKotTheme

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Screen()
        }
    }
}

@Composable
private fun Screen(

) {
    val viewModel: AuthViewModel = hiltViewModel()
    val showStatusIndicator by viewModel.showStatusIndicator

    VKotTheme {
        Column {
            if (showStatusIndicator){
                StatusIndicator(status = "Loading...")
            }
            
            Text(text = showStatusIndicator.toString())

            Surface(modifier = Modifier.fillMaxSize()) {
            }
        }
    }
}

