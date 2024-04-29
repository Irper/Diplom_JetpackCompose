package ru.vovan.diplomcompose.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.audience


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
