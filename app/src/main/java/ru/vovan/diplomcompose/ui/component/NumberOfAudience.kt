package ru.vovan.diplomcompose.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.ui.model.CurrentAudienceObject


@Composable
fun NumberOfAudience(modifier: Modifier, currentAudience: String = CurrentAudienceObject.currentAudience){
    Text(
        text = "Ауд. $currentAudience",
        textAlign = TextAlign.Center,
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}
