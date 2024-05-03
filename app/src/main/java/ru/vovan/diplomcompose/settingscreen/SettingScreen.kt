package ru.vovan.diplomcompose.settingscreen

import android.app.Activity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    var entered by remember { mutableStateOf(false) }

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
            if (entered){
                PassEntered()
            }
            else {
                Password(onClick = {entered = !entered})
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}
@Composable
fun Password(onClick : () -> Unit){
    val correctPass : String = "123"
    var pass by remember { mutableStateOf("") }
    var passVisibility by remember { mutableStateOf(false) }

    val icon = if (passVisibility) painterResource(id = R.drawable.icon_ic_visibility_icon)
    else painterResource(id = R.drawable.icon_ic_off_visibility_icon)

    OutlinedTextField(
        modifier = Modifier
            .border(
            width = 3.dp,
            brush = Brush.horizontalGradient(colors = listOf(mainColor_dark, mainColor_light)),
            shape = RoundedCornerShape(4.dp)
        )
            .widthIn(min = 300.dp, max = 500.dp),
        value = pass,
        onValueChange = { pass = it },
        placeholder = { Text(text = "Введите пароль") },
        visualTransformation = if(passVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passVisibility = !passVisibility }) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true
    )
    ButtonSetting (
        modifier = Modifier.width(200.dp),
        text = stringResource(id = R.string.button_enter),
        onClick = { if(correctPass == pass){ onClick() } }
    )
}
@Composable
fun PassEntered(){
    // Выход из приложения
    val activity = (LocalContext.current as? Activity)

    ButtonSetting (
        text = stringResource(id = R.string.button_assign_audience),
        onClick = { /*TODO*/ }
    )
    ButtonSetting (
        text = stringResource(id = R.string.button_exit),
        onClick = {activity?.finish()}
    )
}

@Composable
fun ButtonSetting(text : String, onClick : () -> Unit, modifier: Modifier = Modifier){
    GradientButton(
        modifier = modifier,
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