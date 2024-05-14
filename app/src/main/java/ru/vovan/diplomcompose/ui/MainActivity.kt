package ru.vovan.diplomcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson
import ru.vovan.diplomcompose.ui.component.NavigationBar
import ru.vovan.diplomcompose.ui.model.AudienceModel
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

var lessons = arrayListOf(
    Lesson(audienceId = "252", numberOfLesson = 1, itemName =  "Механика", date = "22.05.123", group = "БО941САП", itemType =  "Лекция", lecturer = "Владимир Владимирович Лагойда" ),
    Lesson(audienceId = "252", numberOfLesson = 2, itemName =  "Web-программирование", date = "22.05.123", group = "БО941САП", itemType =  "Лекция", lecturer = "Кузнецов И.В." ),
    Lesson(audienceId = "252", numberOfLesson = 3, itemName =  "Управление проектами в сфере информационных технологий", date = "22.05.123", group = "БО941САП, БО941ПРИ, БО941ПИА, БО941БИО, БО941ГИО", itemType =  "Лекция", lecturer = "Белозерова С.И." ),
    Lesson(audienceId = "252", numberOfLesson = 4, itemName =  "Управление проектами в сфере информационных технологий", date = "22.05.123", group = "БО941САП, БО941ПРИ, БО941ПИА, БО941БИО, БО941ГИО", itemType =  "Лекция", lecturer = "Белозерова С.И." ),
    Lesson(audienceId = "252", numberOfLesson = 5, itemName =  "Управление проектами в сфере информационных технологий", date = "22.05.123", group = "БО941САП, БО941ПРИ, БО941ПИА, БО941БИО, БО941ГИО", itemType =  "Лекция", lecturer = "Белозерова С.И." ),
    Lesson(audienceId = "252", numberOfLesson = 6, itemName =  "Управление проектами в сфере информационных технологий", date = "22.05.123", group = "БО941САП, БО941ПРИ, БО941ПИА, БО941БИО, БО941ГИО", itemType =  "Лекция", lecturer = "Белозерова С.И." ),
    )
var audienceModel = AudienceModel( Audience(numberOfAudience = "252", description = "lorem_ipsum"  ), lessons)


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


