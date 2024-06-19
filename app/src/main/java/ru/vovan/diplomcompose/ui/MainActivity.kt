package ru.vovan.diplomcompose.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson
import ru.vovan.diplomcompose.ui.component.NavigationBar
import ru.vovan.diplomcompose.ui.model.CurrentAudience
import ru.vovan.diplomcompose.ui.model.CurrentAudienceObject
import ru.vovan.diplomcompose.ui.model.MapPoint
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.viewmodel.DataViewModel
import ru.vovan.diplomcompose.workrequest.BrowseTimetableWorker
import java.util.concurrent.TimeUnit

var listAnnouncement = listOf(  Announcement(text = "«Дарованные небесами строки. К 225-летию А.С. Пушкина»", date = "06.06.2024"),
                                Announcement(text = "Научно-техническая библиотека приглашает посетить тематическую выставку «Сатиры острое оружие».", date = "06.06.2024"),
                                Announcement(text = "Электронный ресурс - \"Писатели-фронтовики Хабаровского края\"", date = "23.05.2024"),
                                Announcement(text = "У студентов, аспирантов и молодых специалистов ДВГУПС есть возможность принять участие в конкурсном отборе на стипендиальную программу Правительства Вьетнама", date = "02.05.2024")
)
var listAudience = listOf(  Audience("3430", "Лабораторная компьютерная аудитория 3430 предназначена для проведения практических занятий, семинаров и самостоятельной работы студентов, связанных с использованием компьютеров. \nОна оборудована: \n* Компьютерами с необходимым программным обеспечением \n* Сенсорной доской \n"),
                            Audience("3252", "Лекционная аудитория 3252 предназначена для проведения лекционный занятий и семинаров. \nОна оборудована: \n* Компьютером для преподавателя \n* Школьной доской \n* Проектором с экраном"),
                            Audience("3132", "Компьютерная аудитория 3132 предназначена для проведения практических занятий, семинаров и самостоятельной работы студентов, связанных с использованием компьютеров. \nОна оборудована: \n* Компьютерами с необходимым программным обеспечением \n* Школьной доской \n* Проектором с экраном"),

)
var listMapPoint = listOf(  MapPoint("3430", LatLng(48.49434065442388, 135.06084641872027)),
                            MapPoint("3252", LatLng(48.49369542367654, 135.06049504935913)),
                            MapPoint("3132", LatLng(48.49338435909059, 135.06015977325265))
)
var listLesson = listOf(    Lesson(audienceId = "3430", numberOfLesson = 1, itemName =  "Java-программирование", date = "21.06.2024", group =  "Группа БО921ПИА", itemType =  "Лабораторные работы", lecturer =  "Исаев М.С."),
                            Lesson(audienceId = "3430", numberOfLesson = 2, itemName =  "Java-программирование", date = "21.06.2024", group =  "Группа БО921ПРИ", itemType =  "Лабораторные работы", lecturer =  "Исаев М.С."),
                            Lesson(audienceId = "3430", numberOfLesson = 3, itemName =  "Программная инженерия", date = "21.06.2024", group =  "Группа БО941САП", itemType =  "Лекция", lecturer =  "Кузнецов И.В."),
                            Lesson(audienceId = "3430", numberOfLesson = 4, itemName =  "Лингвистическое и программное обеспечение", date = "21.06.2024", group =  "Группа БО941САП", itemType =  "Лабораторные работы", lecturer =  "Тимош П.С."),
                            Lesson(audienceId = "3430", numberOfLesson = 5, itemName =  "Языки и методы программирования", date = "21.06.2024", group =  "Группа БО911ПИА", itemType =  "Лекция", lecturer =  "Кузнецов И.В."),
                            Lesson(audienceId = "3430", numberOfLesson = 6, itemName =  "Языки и методы программирования", date = "21.06.2024", group =  "Группа БО911ПИА", itemType =  "Лабораторные работы", lecturer =  "Кузнецов И.В."),

                            Lesson(audienceId = "3252", numberOfLesson = 1, itemName =  "Метрология, стандартизация и сертификация", date = "21.06.2024", group =  "Группа БО931САП", itemType =  "Лекция", lecturer =  "Белоус Т.В."),
                            Lesson(audienceId = "3252", numberOfLesson = 4, itemName =  "Иностранный язык в профессиональной деятельности", date = "21.06.2024", group =  "Группа БО921ИСГ", itemType =  "Лекция", lecturer =  "Алексеева В.В."),
                            Lesson(audienceId = "3252", numberOfLesson = 5, itemName =  "Тайм-менеджмент", date = "21.06.2024", group =  "Группы БО931ПИА, БО931НГД", itemType =  "Лекция", lecturer =  "Щуковская М.А."),
                            Lesson(audienceId = "3252", numberOfLesson = 6, itemName =  "Тайм-менеджмент", date = "21.06.2024", group =  "Группы БО931САП, БО931ПРИ, БО931ПМИ", itemType =  "Лекция", lecturer =  "Щуковская М.А."),
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
            if (windowInsets.isVisible(WindowInsetsCompat.Type.navigationBars())
                || windowInsets.isVisible(WindowInsetsCompat.Type.statusBars())) {
                 windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
            }
            ViewCompat.onApplyWindowInsets(view, windowInsets)
        }

        super.onCreate(savedInstanceState)
        setContent {
            DiplomComposeTheme {
                MyApp()
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MyApp(dataViewModel: DataViewModel = koinViewModel()){

    val dataStore =  CurrentAudience(context = LocalContext.current)
    GlobalScope.launch {
        dataStore.getAudienceNumber.collect{
            if (it != null) {
                CurrentAudienceObject.currentAudience = it
            }
        }
        dataViewModel.browserTimetable(CurrentAudienceObject.currentAudience)
        dataViewModel.browserAnnouncement()
    }

    val timetableWorker = PeriodicWorkRequestBuilder<BrowseTimetableWorker>(
        10, TimeUnit.SECONDS)
        .build()
    WorkManager.getInstance(LocalContext.current).enqueue(timetableWorker)

    NavigationBar()
}


