package ru.vovan.diplomcompose.startscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.Lesson
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.audience
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.ui.theme.text_blue

@Composable
fun Timetable (modifier: Modifier){
    val lesson_ = audience.lessons
    Surface(
        modifier = modifier
            .widthIn(max = 550.dp)
            .fillMaxHeight()
            .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
            .drawWithContent {
                drawContent()
                drawRect(
                    brush = Brush.verticalGradient(
                        0.91f to Color.White,
                        1f to Color.Transparent
                    ),
                    blendMode = BlendMode.DstIn
                )
            },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TimetableHeader(modifier = Modifier.padding(bottom = 8.dp))
            TimetableLessons(lesson_)
        }
    }
}

@Composable
fun TimetableHeader (modifier: Modifier){
    Text(
        stringResource(id = R.string.title_timetable),
        modifier = modifier,
        fontSize = 32.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TimetableLessons(lessons : List<Lesson>){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(Modifier.height(4.dp))
        for (lesson in lessons) {
            TimetableLesson(lesson)
        }
        Spacer(Modifier.height(32.dp))
    }
}

@Composable
fun TimetableLesson(lesson: Lesson){
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize().background(color = Color.Transparent)
        ) {
            NumberOfLesson(lesson)
            DescriptionOfLesson(lesson)
        }
    }
}

@Composable
fun NumberOfLesson(lesson: Lesson) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
    ) {
        Text(
            text = lesson.number.toString(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = lesson.time_begin,
            fontSize = 18.sp
        )
        Text(
            text = lesson.time_end,
            fontSize = 18.sp
        )
    }
}

@Composable
fun DividingLine (modifier: Modifier){
    Image(
        modifier = modifier
            .padding(top = 8.dp, bottom = 8.dp),
        painter = painterResource(R.drawable.vertical_line),
        contentDescription = null,
    )
}

@Composable
fun DescriptionOfLesson(lesson: Lesson) {
    Column(
        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, end = 4.dp)
    ) {
        Text(
            text = lesson.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(
            modifier = Modifier.padding(bottom = 2.dp),
            fontWeight = FontWeight(500),
            color = text_blue,
            text = if (lesson.group.size == 1)
                stringResource(id = R.string.text_group_timetable) + " " + lesson.group.toString()
            else
                stringResource(id = R.string.text_groups_timetable) + " " + lesson.group.toString()
        )
        Text(
            lineHeight = 17.sp,
            text = lesson.subject + "\n" + lesson.lecturer,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimetablePreview() {
    DiplomComposeTheme {
        Timetable(modifier = Modifier)
    }
}