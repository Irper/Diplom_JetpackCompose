package ru.vovan.diplomcompose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun NumberOfAudience(modifier: Modifier){
    val audienceNumber = audience.number_of_audience
    Text(
        text = "Ауд. " + audienceNumber,
        textAlign = TextAlign.Center,
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
        )
}
