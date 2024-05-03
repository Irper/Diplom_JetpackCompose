package ru.vovan.diplomcompose.settingscreen

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.component.GradientButton
import ru.vovan.diplomcompose.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.ui.theme.mainColor_dark
import ru.vovan.diplomcompose.ui.theme.mainColor_light

@Composable
fun SettingScreen(){
    // Выход из приложения
    val activity = (LocalContext.current as? Activity)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            ButtonSetting (
                text = stringResource(id = R.string.button_assign_audience),
                onClick = { /*TODO*/ }
            )
            ButtonSetting (
                text = stringResource(id = R.string.button_exit),
                onClick = {activity?.finish()}
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun ButtonSetting(text : String, onClick : () -> Unit){
    GradientButton(
        text = text,
        textColor = Color.White,
        gradient = Brush.horizontalGradient(colors = listOf(mainColor_dark, mainColor_light))
    ) { onClick() }
}
@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    DiplomComposeTheme {
        SettingScreen()
    }
}