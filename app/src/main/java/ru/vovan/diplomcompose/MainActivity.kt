package ru.vovan.diplomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.vovan.diplomcompose.startpage.StartPage
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

var lessons = listOf<Lesson>(
    Lesson(1, "Механика", listOf("БО941САП"), "Лекция", "Владимир Владимирович Лагойда" ),
    Lesson(2, "Web-программирование", listOf("БО941САП", "БО941ПРИ"), "Лекция", "Кузнецов И.В." ),
    Lesson(3, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." ),
    Lesson(4, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." ),
    Lesson(5, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." )
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
    StartPage()
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    DiplomComposeTheme {
        MyApp()
    }
}

