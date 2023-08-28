package ru.fakelog.vkot.ui.screen.navigation

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.fakelog.vkot.core.constants.RouteConstants
import ru.fakelog.vkot.core.domain.auth.entity.states.AuthState
import ru.fakelog.vkot.ui.navigation.addMainDestinations
import ru.fakelog.vkot.ui.screen.error.ErrorScreen

@Composable
fun NavScreen(
    navController: NavHostController,
    startDestination: String,
    viewModel: NavViewModel
) {
    val loggedInState by viewModel.loggedInState.collectAsState()

    when (loggedInState) {
        AuthState.Default -> {
            NavHost(navController = navController, startDestination = RouteConstants.AUTH_ROUTE) {
                addMainDestinations(navController)
            }
        }
        is AuthState.Failure -> {
            ErrorScreen((loggedInState as AuthState.Failure))
        }
        AuthState.Loading -> {
            CircularProgressIndicator()
        }
        AuthState.Success -> {
            NavHost(navController = navController, startDestination = startDestination) {
                addMainDestinations(navController)
            }
        }
    }
}