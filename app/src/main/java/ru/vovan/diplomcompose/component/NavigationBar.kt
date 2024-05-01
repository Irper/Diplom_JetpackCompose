package ru.vovan.diplomcompose.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.mapscreen.MapScreen
import ru.vovan.diplomcompose.settingscreen.SettingScreen
import ru.vovan.diplomcompose.startscreen.StartScreen
import ru.vovan.diplomcompose.stuffscreen.StuffScreen
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.ui.theme.mainColor_light

@Composable
fun NavigationBar(){
    val navController = rememberNavController()
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        // NavContainer(navController = navController)
        Scaffold(bottomBar = { NavBottomBar(navController = navController) }) {
            NavContainer(navController = navController, padding = it)
        }
    }

}
val items = listOf(
    Screens.Start,
    Screens.Map,
    Screens.Stuff,
    Screens.Setting
)

@Composable
fun NavBottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row {
            //Image(painter = painterResource(), contentDescription = null)
            BottomNav(navController)
            //Image(painter = painterResource(), contentDescription = null)
        }
    }
}

@Composable
fun BottomNav (navController: NavHostController, modifier: Modifier = Modifier){
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.widthIn(max = 500.dp),
        elevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true
            BottomNavigationItem(
                modifier = Modifier
                    .size(48.dp)
                    .padding(top = 8.dp),
                icon = {
                    Icon(
                        when (screen) {
                            Screens.Start -> painterResource(id = R.drawable.icon_timetable)
                            Screens.Map -> painterResource(id = R.drawable.icon_map)
                            Screens.Stuff -> painterResource(id = R.drawable.icon_stuf)
                            Screens.Setting -> painterResource(id = R.drawable.icon_setting)
                        },
                        contentDescription = null,
                        tint = if (selected) mainColor_light else Color.Black
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavContainer(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        modifier = Modifier.padding(paddingValues = padding),
        navController = navController,
        startDestination = Screens.Start.route
        )
    {
        composable(route = Screens.Start.route) {
            StartScreen()
        }
        composable(route = Screens.Map.route) {
            MapScreen()
        }
        composable(route = Screens.Stuff.route) {
            StuffScreen()
        }
        composable(route = Screens.Setting.route) {
            SettingScreen()
        }
    }
}

sealed class Screens(val route: String) {
    data object Start : Screens("start")
    data object Map : Screens("map")
    data object Stuff : Screens("stuff")
    data object Setting : Screens("setting")
}


@Preview(showBackground = true, widthDp = 1200)
@Composable
fun NavigationBarPreview() {
    DiplomComposeTheme {
        NavigationBar()
    }
}