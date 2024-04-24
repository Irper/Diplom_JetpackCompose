package ru.vovan.diplomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

var lessons = listOf<Lesson>(
    Lesson(1, "Механика", listOf("БО941САП"), "Лекция", "Владимир Владимирович Лагойда" ),
    Lesson(2, "Web-программирование", listOf("БО941САП", "БО941ПРИ"), "Лекция", "Кузнецов И.В." ),
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

@Preview(showBackground = true, heightDp = 260)
@Composable
fun MyAppPreview() {
    DiplomComposeTheme {
        MyApp()
    }
}

