package ru.fakelog.vkot.ui.screen.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ru.fakelog.vkot.core.domain.utils.Result

@Composable
fun ErrorScreen(failure: Result.Failure) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Error!")
        Text(text = "Type: ${failure.failureStatus}")
        Text(text = "Type: ${failure.message}")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Send Error")
        }
    }
}
