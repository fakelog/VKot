package ru.fakelog.vkot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    startDestination: String = MainDestinations.Route.MAIN_ROUTE,
    mainViewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.Route.MAIN_ROUTE) {
            MainScreen(viewModel = mainViewModel, navController = navController)
        }
        composable(MainDestinations.Route.AUTH_ROUTE) {
            val viewModel: AuthViewModel = hiltViewModel()
            AuthScreen(viewModel = viewModel)
        }
    }
}