package ru.vovan.diplomcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme

@Composable
fun Timetable (modifier: Modifier = Modifier){
    val lesson_ = lessons
    Surface(
        modifier = modifier.widthIn(max = 500.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(id = R.string.title_timetable),
                Modifier.padding(6.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Timetable_lessons(lesson_)
        }
    }
}

@Composable
fun Timetable_lessons(lessons : List<Lesson>){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(start = 4.dp, end = 4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Spacer(Modifier.height(4.dp))
        for (lesson in lessons) {
            Timetable_lesson(lesson)
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun Timetable_lesson(lesson: Lesson){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically
        ) {
            NumberOfLesson(lesson)
            Image(
                modifier = Modifier.
                padding(top = 8.dp, bottom = 8.dp).
                size(width = 2.dp, height = 100.dp),
                painter = painterResource(R.drawable.vertical_line),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
            /*Text(
                text = "|",
                fontSize = 70.sp,
                fontWeight = FontWeight(10),
                modifier = Modifier,
                textAlign = TextAlign.Center
            )*/
            DescriptionOfLesson(lesson)
        }
    }
}

@Composable
fun NumberOfLesson(lesson: Lesson) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 8.dp)
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
fun DescriptionOfLesson(lesson: Lesson) {
    Column(
        modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 4.dp)
    ) {
        Text(
            text = lesson.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Группы " + lesson.group.toString()
        )
        Text(
            text = lesson.subject,
            fontSize = 14.sp
        )
        Text(
            text = lesson.lecturer,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimetablePreview() {
    DiplomComposeTheme {
        Timetable()
    }
}