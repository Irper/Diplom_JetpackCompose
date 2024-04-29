package ru.vovan.diplomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.vovan.diplomcompose.component.NavigationBar
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

var lessons = listOf(
    Lesson(1, "Механика", listOf("БО941САП"), "Лекция", "Владимир Владимирович Лагойда" ),
    Lesson(2, "Web-программирование", listOf("БО941САП", "БО941ПРИ"), "Лекция", "Кузнецов И.В." ),
    Lesson(3, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." ),
    Lesson(4, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." ),
    Lesson(5, "Управление проектами в сфере информационных технологий", listOf("БО941САП", "БО941ПРИ", "БО941ПИА", "БО941БИО", "БО941ГИО" ), "Лекция", "Белозерова С.И." )
)
var announcement = listOf(
    Announcement("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","19.02.2002"),
    Announcement("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","56.34.1223"),
    Announcement("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","11.11.1111"),
)
var audience = Audience(252, lessons, announcement)


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
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false // Status & Navigation bars

    NavigationBar()
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    DiplomComposeTheme {
        NavigationBar()
    }
}

