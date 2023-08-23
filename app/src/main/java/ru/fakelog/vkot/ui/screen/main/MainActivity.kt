package ru.fakelog.vkot.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.fakelog.vkot.ui.navigation.MainDestinations
import ru.fakelog.vkot.ui.navigation.VKotNavHost
import ru.fakelog.vkot.ui.theme.VKotTheme

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Content()
        }
    }
}

@Composable
private fun Content(
    viewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    VKotTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            VKotNavHost(navController, startDestination = MainDestinations.Route.MAIN_ROUTE)
        }
    }
}