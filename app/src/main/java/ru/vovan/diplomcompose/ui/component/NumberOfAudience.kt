package ru.vovan.diplomcompose.ui.component

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.vovan.diplomcompose.viewmodel.DataViewModel


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NumberOfAudience(modifier: Modifier, dataViewModel: DataViewModel = koinViewModel()){
    var audience by rememberSaveable { mutableStateOf("") }

    dataViewModel.viewModelScope.launch {
        val audienceTemp = dataViewModel.readByIdAudience("101")
        if (audienceTemp != null) {
            audience = audienceTemp.numberOfAudience
        }
    }

    Text(
        text = "Ауд. $audience",
        textAlign = TextAlign.Center,
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )


}
