package ru.vovan.diplomcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.compose.koinViewModel
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.component.NumberOfAudience
import ru.vovan.diplomcompose.ui.model.TestDataImage
import ru.vovan.diplomcompose.ui.model.TestDataImageItem
import ru.vovan.diplomcompose.ui.theme.DiplomComposeTheme
import ru.vovan.diplomcompose.viewmodel.DataViewModel

@Composable
fun StuffScreen(dataViewModel: DataViewModel = koinViewModel()){
    //val stringLesson by dataViewModel.getAllTimetable().collectAsState(initial = Timetable())
    var selectedImageItem by remember { mutableStateOf<TestDataImageItem?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NumberOfAudience(modifier = Modifier
            .padding(top = 10.dp)
            .align(Alignment.CenterHorizontally)
        )
        Text(text = stringResource(id = R.string.lorem_impum_long),
            fontSize = 30.sp,
            lineHeight = 30.sp,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
        AudiencePhotos(
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        ) { newValue -> selectedImageItem = newValue as TestDataImageItem? }
    }
    if (selectedImageItem != null) {
        FullScreenImage(feedItem = selectedImageItem) {
            selectedImageItem = null
        }
    }
}

@Composable
fun AudiencePhotos(modifier: Modifier, onClick: (Any?) -> Unit){
    val feedItems: List<TestDataImageItem> = TestDataImage.testItemsList

    LazyRow (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 30.dp, end = 30.dp)
        ) {
        items(feedItems){
            item ->
            Box(modifier = Modifier
                .height(250.dp)
                .width(250.dp)
            ){
                Image(
                    painter = rememberAsyncImagePainter(model = item.url),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clickable { onClick(item) }
                )
            }
        }
    }
}

@Composable
fun FullScreenImage(feedItem: TestDataImageItem?, onDismiss: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray.copy(alpha = 0.75f))
            .clickable { onDismiss() }
        )
        Image(
            painter = rememberAsyncImagePainter(model = feedItem?.url),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth(0.8f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StuffScreenPreview() {
    DiplomComposeTheme {
        StuffScreen()
    }
}