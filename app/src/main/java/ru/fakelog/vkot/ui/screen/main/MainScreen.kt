package ru.fakelog.vkot.ui.screen.main

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import ru.fakelog.vkot.ui.navigation.MainDestinations
import ru.fakelog.vkot.utils.HashUtils

@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavController) {
    val context = LocalContext.current

    // Вычисление хэш-суммы в фоновом потоке
    val checksum = remember { mutableStateOf("") }
    val algorithm = "SHA-256"

    val computedChecksum = HashUtils.getSelfChecksum(context, algorithm)
    checksum.value = computedChecksum ?: "Ошибка при вычислении хэш-суммы"

    Text(
        text = checksum.value
    )
    
    Button(
        onClick = {
            navController.popBackStack()
            navController.navigate(MainDestinations.Route.AUTH_ROUTE)
        }
    ) {

    }
}