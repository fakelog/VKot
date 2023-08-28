package ru.fakelog.vkot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.fakelog.vkot.core.constants.RouteConstants
import ru.fakelog.vkot.ui.screen.auth.AuthScreen
import ru.fakelog.vkot.ui.screen.auth.AuthViewModel
import ru.fakelog.vkot.ui.screen.main.MainScreen
import ru.fakelog.vkot.ui.screen.main.MainViewModel
import ru.fakelog.vkot.ui.screen.navigation.NavScreen
import ru.fakelog.vkot.ui.screen.navigation.NavViewModel

@Composable
fun VKotNavHost(
    navController: NavHostController,
    startDestination: String = RouteConstants.MAIN_ROUTE
) {
    val navViewModel = hiltViewModel<NavViewModel>()
    NavScreen(navController = navController, startDestination = startDestination, viewModel = navViewModel)
}

fun NavGraphBuilder.addMainDestinations(navController: NavHostController) {
    composable(RouteConstants.AUTH_ROUTE) {
        val viewModel = hiltViewModel<AuthViewModel>()
        AuthScreen(navController, viewModel)
    }
    composable(RouteConstants.MAIN_ROUTE) {
        val viewModel = hiltViewModel<MainViewModel>()
        MainScreen(navController, viewModel)
    }
}