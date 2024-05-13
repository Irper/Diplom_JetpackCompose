package ru.vovan.diplomcompose.ui.component

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.ui.audienceModel
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.viewmodel.DataViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Announcement(modifier: Modifier = Modifier, dataViewModel: DataViewModel = koinViewModel()){

    val posts by dataViewModel.getAllPosts().collectAsState(initial = emptyList())
    audienceModel.setAnnouncement(posts)

        audienceModel.listAnnouncement.forEach {
            dataViewModel.viewModelScope.launch {
                dataViewModel.update(Announcement(text = it.text, date = it.date))
        }
    }

    var currentAnnouncement by rememberSaveable { mutableIntStateOf(0) }
    val announcement = audienceModel.listAnnouncement[if (currentAnnouncement >= 0) currentAnnouncement % audienceModel.listAnnouncement.count()
    else  (currentAnnouncement + (audienceModel.listAnnouncement.count() * (-currentAnnouncement))) % audienceModel.listAnnouncement.count()]

    Column (modifier = modifier) {
        AnnouncementHead(modifier = Modifier.align(Alignment.CenterHorizontally))
        AnnouncementBody(announcement, {currentAnnouncement++}, {currentAnnouncement--}, currentAnnouncement)
        AnnouncementBottom(modifier = Modifier.align(Alignment.End), announcement)
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


@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun AnnouncementBody(
    announcement : Announcement,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    count : Int
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.widthIn(max = 500.dp)
    ) {
        IconButton(
            onClick = onDecrement,
            modifier = Modifier.padding(end = 15.dp)
            ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "Arrow_left",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        AnimatedContent(
            modifier = Modifier.weight(5f),
            targetState = count,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInHorizontally { width -> width } + fadeIn() togetherWith
                            slideOutHorizontally { width -> -width } + fadeOut()
                } else {
                    slideInHorizontally { width -> -width } + fadeIn() togetherWith
                            slideOutHorizontally { width -> width } + fadeOut()
                }
            },
            label = "swipe effect"
        ) {
            Text(
                text = announcement.text,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }

        IconButton(
            onClick = onIncrement,
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Arrow_right",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}


@Composable
fun AnnouncementBottom(modifier: Modifier, announcement : Announcement){
    Text(
        text = announcement.date,
        textAlign = TextAlign.End,
        modifier = modifier.padding(top = 16.dp, end = 64.dp)
    )
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun AnnouncementPreview() {
    DiplomComposeTheme {
        Announcement(modifier = Modifier)
    }
}