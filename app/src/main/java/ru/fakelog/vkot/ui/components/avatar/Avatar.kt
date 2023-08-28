package ru.fakelog.vkot.ui.components.avatar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideSubcomposition
import com.bumptech.glide.integration.compose.RequestState

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Avatar(
    label: String?
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            modifier = Modifier.size(72.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
        ) {
            GlideSubcomposition(
                model = "",
            ) {
                when (state) {
                    RequestState.Failure -> TODO()
                    RequestState.Loading -> CircularProgressIndicator()
                    is RequestState.Success -> Image(
                        painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        label?.let { Text(text = it) }
    }
}