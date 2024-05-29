package ru.vovan.diplomcompose.ui.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.component.GradientButton
import ru.vovan.diplomcompose.ui.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.ui.theme.mainColor_dark
import ru.vovan.diplomcompose.ui.theme.mainColor_light
import kotlin.math.roundToInt

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



@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun Password(onClick : () -> Unit){
    val correctPass : String = "123"
    var pass by remember { mutableStateOf("") }
    var passVisibility by remember { mutableStateOf(false) }
    var enteredIncorrectPass by remember { mutableStateOf(false) }
    var enteredIncorrectPassCount by remember { mutableIntStateOf(0) }

    val shake = remember { Animatable(0f) }
    LaunchedEffect(enteredIncorrectPassCount) {
        if (enteredIncorrectPassCount != 0) {
            for (i in 0..10) {
                when (i % 2) {
                    0 -> shake.animateTo(5f, spring(stiffness = 100_000f))
                    else -> shake.animateTo(-5f, spring(stiffness = 100_000f))
                }
            }
            shake.animateTo(0f)
        }
    }

    val icon = if (passVisibility) painterResource(id = R.drawable.icon_ic_visibility_icon)
    else painterResource(id = R.drawable.icon_ic_off_visibility_icon)

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
    ){
        OutlinedTextField(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .border(
                    width = 3.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(mainColor_dark, mainColor_light)
                    ),
                    shape = RoundedCornerShape(4.dp)
                )
                .widthIn(min = 300.dp, max = 500.dp),
            value = pass,
            onValueChange = { pass = it },
            placeholder = { Text(text = "Введите пароль") },
            visualTransformation = if (passVisibility) VisualTransformation.None
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
        if (enteredIncorrectPass){
            Text(
                text = stringResource(id = R.string.label_incorrect),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color.Red,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .offset { IntOffset(shake.value.roundToInt(), y = 0) }
            )
        }
    }

    ButtonSetting (
        modifier = Modifier.width(200.dp),
        text = stringResource(id = R.string.button_enter),
        onClick = {
            if(correctPass == pass)
                onClick()
            else
                enteredIncorrectPass = true
                enteredIncorrectPassCount++
        }
    )
}

@Composable
fun PassEntered(){
    // Выход из приложения
    val activity = (LocalContext.current as? Activity)

    ExposedDropdownMenuBox()
    ButtonSetting (
        text = stringResource(id = R.string.button_exit),
        onClick = {activity?.finish()}
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBox(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val currentAud = arrayOf("101", "1011")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by rememberSaveable { mutableStateOf(currentAud[0]) }

    Box() {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                currentAud.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
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

    }
}