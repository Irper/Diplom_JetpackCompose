package ru.vovan.diplomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

var lessons = listOf<Lesson>(
    Lesson(1, "Механика", listOf("БО941САП"), "Лекция", "Владимир Владимирович Лагойда" ),
    Lesson(2, "Web-программирование", listOf("БО941САП", "БО941ПРИ"), "Лекция", "Кузнецов И.В." ),
    Lesson(3, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiplomComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    Timetable(modifier = Modifier)
}

@Preview(showBackground = true, heightDp = 250)
@Composable
fun MyAppPreview() {
    DiplomComposeTheme {
        MyApp()
    }
}

