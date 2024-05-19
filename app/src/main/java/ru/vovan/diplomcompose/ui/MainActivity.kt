package ru.vovan.diplomcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.vovan.diplomcompose.ui.component.NavigationBar
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

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


