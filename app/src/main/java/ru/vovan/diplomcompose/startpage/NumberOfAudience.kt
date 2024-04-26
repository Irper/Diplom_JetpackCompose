package ru.vovan.diplomcompose.startpage

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun NumberOfAudience(modifier: Modifier){
    Text(
        text = "Ауд. 428",
        textAlign = TextAlign.Center,
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
        )
}
