package ru.fakelog.vkot.ui.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.fakelog.vkot.R
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.core.domain.auth.entity.enums.AuthButton
import ru.fakelog.vkot.core.domain.utils.Result
import ru.fakelog.vkot.ui.screen.auth.accounts.AccountsScreen
import ru.fakelog.vkot.ui.screen.auth.login.LoginScreen
import ru.fakelog.vkot.ui.screen.error.ErrorScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {
    val accountsState by viewModel.allAccountsState.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet by viewModel.showBottomSheet.collectAsState()

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(0.01f))
        Text(text = stringResource(R.string.vkot_id))
        Spacer(Modifier.weight(0.3f))
        Text(
            text = stringResource(R.string.login_vk),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.weight(0.1f))
        Column {
            when (accountsState) {
                Result.Default -> {
                    Button(onClick = {
                        viewModel.setClickedButton(AuthButton.LOGIN)
                        viewModel.setShowBottomSheet(true)
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = stringResource(R.string.login))
                    }
                    FilledTonalButton(onClick = {
                        viewModel.setClickedButton(AuthButton.REGISTRATION)
                        viewModel.setShowBottomSheet(true)
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = stringResource(R.string.registration))
                    }
                }
                is Result.Failure -> ErrorScreen(failure = accountsState as Result.Failure)
                Result.Loading -> CircularProgressIndicator()
                is Result.Success -> AccountsScreen(
                    accounts = (accountsState as Result.Success<List<AccountEntity?>>).value
                )
            }
        }

        Spacer(Modifier.weight(1f))
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Settings")
        }
        Spacer(Modifier.weight(0.01f))
    }

    if (showBottomSheet) {
        val clickedButton by viewModel.clickedButton.collectAsState()

        ModalBottomSheet(
            onDismissRequest = { viewModel.setShowBottomSheet(false) },
            sheetState = sheetState
        ) {
            when (clickedButton) {
                AuthButton.LOGIN -> {
                    LoginScreen(navController = navController)
                }
                AuthButton.REGISTRATION -> {
                    TODO("Make reg. screen")
                }
                else -> {
                    viewModel.setShowBottomSheet(false)
                }
            }
        }
    }
}