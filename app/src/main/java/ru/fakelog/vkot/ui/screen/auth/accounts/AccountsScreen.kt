package ru.fakelog.vkot.ui.screen.auth.accounts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.fakelog.vkot.R
import ru.fakelog.vkot.core.data.accounts.data_source.local.AccountEntity
import ru.fakelog.vkot.ui.components.avatar.Avatar

@Composable
fun AccountsScreen(accounts: List<AccountEntity?>) {
    Column {
        Spacer(modifier = Modifier.weight(0.25f))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            items(accounts) {
                Avatar(label = it?.userId.toString())
            }
        }

        Spacer(modifier = Modifier.weight(0.1f))

        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp)) {
            Text(text = stringResource(R.string.login))
        }

        Spacer(modifier = Modifier.weight(1f))
    }

}