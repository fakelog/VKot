package ru.fakelog.vkot.ui.screen.auth.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.fakelog.vkot.R


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginMessage by viewModel.loginMessage.collectAsState()

    Column (
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "Введите телефон или почту, которые привязаны к аккаунту",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        OutlinedTextField(
            value = viewModel.username.value,
            onValueChange = { text -> viewModel.setUsername(text) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Phone or email") }
        )
        OutlinedTextField(
            value = viewModel.password.value,
            onValueChange = { text -> viewModel.setPassword(text) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Password") }
        )
        Row {
            Spacer(Modifier.weight(1f))
            Button(onClick = { viewModel.onLoginClicked() }) {
                Text(text = stringResource(R.string.login))
            }
        }
        loginMessage?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
