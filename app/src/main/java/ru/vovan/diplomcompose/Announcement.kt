package ru.vovan.diplomcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun Announcement(modifier: Modifier){
    Surface {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.widthIn(max = 500.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "Arrow_left",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Lorem ipsum 1231 12312",
                //stringResource(id = R.string.lorem_ipsum)
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Arrow_right",
                modifier = Modifier.padding(start = 8.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnnouncementPreview() {
    DiplomComposeTheme {
        Announcement(modifier = Modifier)
    }
}