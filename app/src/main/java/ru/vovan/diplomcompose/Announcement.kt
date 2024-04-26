package ru.vovan.diplomcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun Announcement(modifier: Modifier){
    Surface {
        Column () {
            AnnouncementHead(modifier = Modifier.align(Alignment.CenterHorizontally))
            AnnouncementBody()
            AnnouncementBottom(modifier = Modifier.align(Alignment.End))
        }
    }
}

@Composable
fun AnnouncementHead(modifier: Modifier){
    Text(
        text = stringResource(id = R.string.announcement_head),
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        modifier = modifier.padding(bottom = 36.dp)
    )
}

@Composable
fun AnnouncementBody(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.widthIn(max = 500.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Arrow_left",
            modifier = Modifier
                .padding(end = 20.dp)
                .size(30.dp, 40.dp)
        )
        Text(
            text = stringResource(id = R.string.lorem_ipsum),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.weight(5f)
        )
        Image(
            painter = painterResource(id = R.drawable.arrow_right),
            contentDescription = "Arrow_right",
            modifier = Modifier
                .padding(start = 20.dp)
                .size(30.dp, 40.dp)
        )
    }
}
@Composable
fun AnnouncementBottom(modifier: Modifier){
    Text(
        text = "09.09.2024",
        textAlign = TextAlign.End,
        modifier = modifier.padding(top = 16.dp, end = 50.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AnnouncementPreview() {
    DiplomComposeTheme {
        Announcement(modifier = Modifier)
    }
}