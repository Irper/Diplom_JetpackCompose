package ru.vovan.diplomcompose.settingpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.GradientButton
import ru.vovan.diplomcompose.Menu
import ru.vovan.diplomcompose.NumberOfAudience
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.ui.theme.mainColor_dark
import ru.vovan.diplomcompose.ui.theme.mainColor_light

@Composable
fun SettingPage(){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            GradientButton(
                text = stringResource(id = R.string.button_assign_audience),
                textColor = Color.White,
                gradient = Brush.horizontalGradient(colors = listOf(mainColor_dark, mainColor_light))
            ) { /*TODO*/ }
            GradientButton(
                text =  stringResource(id = R.string.button_exit),
                textColor = Color.White,
                gradient = Brush.horizontalGradient(colors = listOf(mainColor_dark, mainColor_light))
            ) { /*TODO*/ }
        }
        Menu(modifier = Modifier.padding(bottom = 40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SettingPagePreview() {
    DiplomComposeTheme {
        SettingPage()
    }
}