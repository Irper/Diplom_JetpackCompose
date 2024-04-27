package ru.vovan.diplomcompose.startpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vovan.diplomcompose.Menu
import ru.vovan.diplomcompose.NumberOfAudience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun StartPage()
{
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Timetable(modifier = Modifier)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 60.dp)
        ) {
            NumberOfAudience(modifier = Modifier.padding(top = 10.dp))
            Announcement(modifier = Modifier)
            Menu(modifier = Modifier.padding(bottom = 40.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 1600)
@Composable
fun StartPagePreview() {
    DiplomComposeTheme {
        StartPage()
    }
}