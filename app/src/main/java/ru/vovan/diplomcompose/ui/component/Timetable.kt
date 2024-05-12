package ru.vovan.diplomcompose.ui.component

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.delay
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.database.entity.Lesson
import ru.vovan.diplomcompose.ui.audienceModel
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.ui.theme.alternative_dark
import ru.vovan.diplomcompose.ui.theme.alternative_light
import ru.vovan.diplomcompose.ui.theme.prepareLesson_dark
import ru.vovan.diplomcompose.ui.theme.prepareLesson_light
import ru.vovan.diplomcompose.ui.theme.text_blue
import java.util.Calendar

@Composable
fun Timetable (modifier: Modifier){
    val lessons_ = audienceModel.listLesson

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TimetableHeader(modifier = Modifier.padding(bottom = 8.dp))
            TimetableLessons(lessons_)
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
    var hour by rememberSaveable { mutableIntStateOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) }
    var minute by rememberSaveable { mutableIntStateOf(Calendar.getInstance().get(Calendar.MINUTE)) }
    var time by rememberSaveable { mutableDoubleStateOf(0.0) }

    LaunchedEffect(Unit) {
        while (true) {
            hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            minute = Calendar.getInstance().get(Calendar.MINUTE)
            val timeTemp : String = "$hour." + if (minute in 0 .. 9) "0$minute" else "$minute"
            time = timeTemp.toDouble()
            delay(60000) // Update hour every minute
        }
    }


    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = if (setCurrentLessonGradient(lesson.numberOfLesson, time)) {
                    Brush.horizontalGradient(colors = listOf(alternative_dark, alternative_light))
                }
                else if(setCurrentPrepareLessonGradient(lesson.numberOfLesson, time)) {
                    Brush.horizontalGradient(colors = listOf(prepareLesson_dark, prepareLesson_light))
                }
                else{ Brush.horizontalGradient(colors = listOf(Color.White, Color.White)) },
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            NumberOfLesson(lesson)
            DescriptionOfLesson(lesson)
        }
    }
}

fun setCurrentLessonGradient(numberLesson : Int, time : Double) : Boolean{
    if (numberLesson == 1 && time in 8.05..9.35 ){
        return true
    }
    else if (numberLesson == 2 && time in 9.50..11.20 ){
        return true
    }
    else if (numberLesson == 3 && time in 11.35..13.05 ){
        return true
    }
    else if (numberLesson == 4 && time in 13.35..15.05 ){
        return true
    }
    else if (numberLesson == 5 && time in 15.15..16.45 ){
        return true
    }
    else if (numberLesson == 6 && time in 16.55..18.25 ){
        return true
    }
    else{
        return false
    }
}
fun setCurrentPrepareLessonGradient(numberLesson : Int, time : Double) : Boolean{
    if (numberLesson == 1 && time in 7.50..8.04 ){
        return true
    }
    else if (numberLesson == 2 && time in 9.36..9.49 ){
        return true
    }
    else if (numberLesson == 3 && time in 11.21..11.34 ){
        return true
    }
    else if (numberLesson == 4 && time in 13.06..13.34 ){
        return true
    }
    else if (numberLesson == 5 && time in 15.06..15.14 ){
        return true
    }
    else if (numberLesson == 6 && time in 16.46..16.54 ){
        return true
    }
    else{
        return false
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
            text = lesson.numberOfLesson.toString(),
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
            text = lesson.itemName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(
            modifier = Modifier.padding(bottom = 2.dp),
            fontWeight = FontWeight(500),
            color = text_blue,
            text = lesson.group
            /*text = if (lesson.group.size == 1)
                stringResource(id = R.string.text_group_timetable) + " " + lesson.group.toString()
            else
                stringResource(id = R.string.text_groups_timetable) + " " + lesson.group.toString()*/
        )
        Text(
            lineHeight = 17.sp,
            text = lesson.itemType + "\n" + lesson.lecturer,
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