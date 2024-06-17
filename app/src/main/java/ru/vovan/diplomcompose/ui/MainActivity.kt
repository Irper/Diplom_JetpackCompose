package ru.vovan.diplomcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.koinViewModel
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.ui.component.NavigationBar
import ru.vovan.diplomcompose.ui.model.CurrentAudience
import ru.vovan.diplomcompose.ui.model.CurrentAudienceObject
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.viewmodel.DataViewModel
import ru.vovan.diplomcompose.workrequest.BrowseTimetableWorker
import java.util.concurrent.TimeUnit

var listAnnouncement = listOf(  Announcement(text = "«Дарованные небесами строки. К 225-летию А.С. Пушкина»", date = "06.06.2024"),
                                Announcement(text = "Научно-техническая библиотека приглашает посетить тематическую выставку «Сатиры острое оружие».", date = "06.06.2024"),
                                Announcement(text = "Электронный ресурс - \"Писатели-фронтовики Хабаровского края\"", date = "23.05.2024"),
                                Announcement(text = "У студентов, аспирантов и молодых специалистов ДВГУПС есть возможность принять участие в конкурсном отборе на стипендиальную программу Правительства Вьетнама", date = "02.05.2024")
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
fun MyApp(dataViewModel: DataViewModel = koinViewModel()){

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false // Status & Navigation bars

    val dataStore =  CurrentAudience(context = LocalContext.current)
    LaunchedEffect("launch") {
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


