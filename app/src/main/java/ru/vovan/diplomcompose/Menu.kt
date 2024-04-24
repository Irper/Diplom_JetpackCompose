package ru.vovan.diplomcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun Menu() {
    Row {
        MenuIcon(painter = painterResource(id = R.drawable.icon_timetable), tint = Color.Green)
        MenuIcon(painter = painterResource(id = R.drawable.icon_map), tint = Color.Black)
        MenuIcon(painter = painterResource(id = R.drawable.icon_stuf), tint = Color.Black)
        MenuIcon(painter = painterResource(id = R.drawable.icon_setting), tint = Color.Black)
    }
}

@Composable
fun MenuIcon(painter : Painter, tint : Color){
    IconButton(onClick = { } ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.sizeIn(48.dp),
            tint = tint
        )
    }
}

@Preview (showBackground = true)
@Composable
fun MenuPreview() {
    DiplomComposeTheme {
        Menu()
    }
}