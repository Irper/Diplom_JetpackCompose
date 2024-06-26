package ru.vovan.diplomcompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = buttonColors(
            Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Box(
            modifier = modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 30.sp
            )
        }
    }
}