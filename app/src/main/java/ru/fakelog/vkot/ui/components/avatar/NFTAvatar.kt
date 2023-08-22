package ru.fakelog.vkot.ui.components.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NFTAvatar(
//    drawableResource: Int,
//    description: String,
    modifier: Modifier = Modifier
){
    Box(
    ) {
        Text(text = "123")
//        Image(
//            painter = painterResource(id = drawableResource),
//            contentDescription = description
//        )
    }
}

@Preview
@Composable
fun NFTAvatarPreview() { NFTAvatar() }