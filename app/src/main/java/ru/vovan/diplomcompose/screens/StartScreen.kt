package ru.vovan.diplomcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.component.Announcement
import ru.vovan.diplomcompose.component.NumberOfAudience
import ru.vovan.diplomcompose.component.Timetable
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun StartScreen()
{
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Timetable(modifier = Modifier.padding(start = 40.dp, top = 30.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 20.dp, end = 60.dp)
        ) {
            NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
            Announcement(modifier = Modifier)
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 1600)
@Composable
fun StartScreenPreview() {
    DiplomComposeTheme {
        StartScreen()
    }
}