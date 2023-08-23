package ru.fakelog.vkot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.fakelog.vkot.ui.screen.auth.AuthScreen
import ru.fakelog.vkot.ui.screen.auth.AuthViewModel
import ru.fakelog.vkot.ui.screen.main.MainScreen
import ru.fakelog.vkot.ui.screen.main.MainViewModel

object MainDestinations {

    object Route {
        const val AUTH_ROUTE = "auth"
        const val MAIN_ROUTE = "main"
    }
}

@Composable
fun VKotNavHost(
    navController: NavHostController,
    startDestination: String = MainDestinations.Route.MAIN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.Route.AUTH_ROUTE) {
            val viewModel = hiltViewModel<AuthViewModel>()
            AuthScreen(navController, viewModel)
        }
        composable(MainDestinations.Route.MAIN_ROUTE) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController, viewModel)
        }
    }
}