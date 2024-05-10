package ru.vovan.diplomcompose.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.ui.audienceModel


@Composable
fun NumberOfAudience(modifier: Modifier){
    val audienceNumber = audienceModel.numberOfAudience
    Text(
        text = "Ауд. " + audienceNumber,
        textAlign = TextAlign.Center,
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
        )
}
