package ru.fakelog.vkot.ui.screen.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ru.fakelog.vkot.core.domain.utils.FailureStatus

@Composable
fun ErrorScreen(failureStatus: FailureStatus) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Error!")
        Text(text = "Type: $failureStatus")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Send Error")
        }
    }
}
