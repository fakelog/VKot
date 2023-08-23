package ru.fakelog.vkot.ui.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.fakelog.vkot.ui.screen.auth.login.LoginScreen
import ru.fakelog.vkot.ui.screen.auth.login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    viewModel: AuthViewModel
) {
    //val viewModel: AuthViewModel = hiltViewModel()
    //val loginViewModel = hiltViewModel<LoginViewModel>()
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet by viewModel.showBottomSheet

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(0.01f))
        Text(text = stringResource(R.string.vkot_id))
        Spacer(Modifier.weight(0.30f))
        Text(
            text = stringResource(R.string.login_vk),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Button(onClick = { viewModel.setShowBottomSheet(true) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
        FilledTonalButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Registration")
        }
        Spacer(Modifier.weight(1f))
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                viewModel.setShowBottomSheet(false)
            },
            sheetState = sheetState
        ) {
            LoginScreen()
        }
    }
}
